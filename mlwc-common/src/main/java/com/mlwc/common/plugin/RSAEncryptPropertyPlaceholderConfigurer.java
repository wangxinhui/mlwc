package com.mlwc.common.plugin;

import com.mlwc.common.util.AESUtil;
import com.mlwc.common.util.RSAUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 支持加密配置文件插件
 * Created by ZhangShuzheng on 2017/2/4.
 */
public class RSAEncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] encryptPropNames = {"master.jdbc.password","slave.jdbc.password"};

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		String privateKey = "MIIBhQIBADANBgkqhkiG9w0BAQEFAASCAW8wggFrAgEAAkwA4A0Q7RsbBBxjNdHnw3xwzQ4e213hcRHb9FwXbViA73BS9wuOr_yeBjpeVjWXFFTbBM0kKBju7Ba0mSqxLcyp9I2WAF27Z6wfVCC5AgMBAAECSwjJOmKx72tH2bQgmSAXXy0LYrZjhhWzB5cbjWeiUtwQ4ZACigPnjZlkag4Q0n_w5ve13vv9ET6DwQTSRhP11-pn0AwzMJ68Vq0kiQImDwFMFMG2b_XGmbxIu-vzYONA8ta0RY_QgbJpT8Yyhwqo-5DcDB8CJg7ug1wN7vmSFjUnCnoj5jhrvCx60tYZX0r6tOfm6Zs9miL36LgnAiYAxeBVcWUkf1SrtrdIdu8inpJJ8CV5L99dzwL9yQfxTOtHij7LoQImCNGvHEvOffFe1H3-ni1d6K0ZM1xH8tSBiBOTjfTAvUQhKc4q0bkCJgguvssOeDEb0NlFdb3CiJ-F2Thnf9Ez7tT_dpVRohOOLYtCcwXE";
		if (isEncryptProp(propertyName)){
			try {
				String decryptValue = RSAUtil.privateDecrypt(propertyValue,RSAUtil.getPrivateKey(privateKey));
				return decryptValue;
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

	private boolean isEncryptProp(String propertyName){
		for (String name:encryptPropNames) {
			if (name.equals(propertyName)){
				return true;
			}
		}
		return false;
	}
}
