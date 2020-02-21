package com.kev.springboot.backend.tienda.online.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA="alguna.clave.secreta.123456789";

	//generado por consola ->openssl genrsa -out jwt.pem
	//luego -> openssl rsa -in jwt.pem
	
	public static final String RSA_PRIVATE="-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpQIBAAKCAQEAwN+Ispxjp7qNj5XT5FeX1VAPAp68s3hgukR08+AeNzxnGhqX\r\n" + 
			"/h0KEnRN2khg/bK6qTFI1wYy3QZk8ptUBrqCdLlLBSVPn44WWKQfebt4EqSQlG25\r\n" + 
			"C91dav+NCUNldO2HW4DgXWvt+B/pKAtReJ+qh3AANYA709zbFirwhRW2mkQRQO8b\r\n" + 
			"OArL9c0z8iAhuVbm/VgB3lpGPnA6tAV7e3vlNJ23IlngHJNDEv/MljOwPcaiWPTZ\r\n" + 
			"2+D6DAqsvgRP1EBCyadZ5sNJu3mlSVGy6LNowjEMl+gtiyiHN3cft9x3JnOK5tO0\r\n" + 
			"VwUUy6UF1ewtjZnke5MYdm6y/+3Hj6sVwiR6lwIDAQABAoIBAQCDsFx6b3NPk32S\r\n" + 
			"Wx95GiGOQQJurIl1FK0eoR0lYpHe7vwKg7vhglxdK1H4x1CKCB2Q5hiw0Aesh/An\r\n" + 
			"Ac1GZtQp9FX3pnkOHQq+7Ricmlaqi/g3kA83vaZKJ0BZ4c2FH6U64ezPfKDXuJoO\r\n" + 
			"gGPZM1NQ9DUAUpUG3BYutZTRmXi7LK0LscxX2uh6FKrZsINHuGYCkKsDkj0emGMr\r\n" + 
			"eWSiUhz5IIhlyxKntLmBUNnq9UYosUfIFYr/ZGmJpkiya5cJU5uXd2ezUXBL6uLA\r\n" + 
			"0IuWYCkbAw53PcTfEVyt1I8ZendvxMEMV/GhHYqOVL86SW4Ph7wScVDfsN6Z8ive\r\n" + 
			"7SbUsbRxAoGBAOIItfjxt71twZzDMPLeMMrkwkie1XEahvBeuGWcqEHXgTBi6rSZ\r\n" + 
			"j0aCuYFZ1e8Pq/ngeJOkz6IEyoErOx3GzhfxMm8zAzROjHCKqPA6yiXd4g3djkHG\r\n" + 
			"VqJzFzNGItGBxQU1DJvUKO/zMZ6aY2A5xHP92JmxXyoFitcUMsgsDqyZAoGBANpx\r\n" + 
			"Y4s5RH6qBZQAGYTdc1h0D4WEWPFCnQBfSW9NtrAb3ZprrlnI8RySmGU4z/adbADH\r\n" + 
			"XBk+Ba9MA1YVHw9pehR+MhaVjz1SdEgxPSDDNNVrIUf0qiQVBCvz++Qxu2GJ3D72\r\n" + 
			"6TXmXvgaFLvYxKAIvBGeLRSTVbJHh80aTa1IgS6vAoGBAIt1WmkNIhNzC3jgCWxf\r\n" + 
			"YHVebOyHayOMfWMC3fx7imiNQT0MWskw0XBsqW3Acrk7zxytvVdC4YSSNis59BBs\r\n" + 
			"H64v97EaJUj5ibbKJm+Jpj10x8tMPkAg0kUKg270P/lJeri6wVvHq7ZYMu4rTVMK\r\n" + 
			"cUYrgZ9aC2AO6VnIMYjFfgxJAoGBAJt0HCIlJBB8ELIti/uY2RA2sCEVeXJgNHji\r\n" + 
			"VtFF3d/gRMkzHoW40ZXC4X8PejgH+adoOKuiDsucbbdiGpOOPZm94Qlfb+t09Vm2\r\n" + 
			"6MibAstqjOm3PSmmZyycWkMf/TjBsiKA9qAsDKPFc8Hm1q8I6EYlafF9lHvmGcel\r\n" + 
			"k2fg9EXzAoGAdINOZYw9S9y0EfUkRRPQgVMJE37fFRUOxykmMb2Wmc5RyBCoHzhk\r\n" + 
			"KbVcHPql4+hWDjZagwRL5H/EOtVSIsIGlsOoAfHk1D+3oHmWNShptOWQACWGq5Cb\r\n" + 
			"YxdmBiY55nb+WqDwclsPAadORdKtPg2ktr9DMl/1amrn6/sjyr0/vDg=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	//luego->openssl rsa -in jwt.pem -pubout
	public static final String RSA_PUBLIC="-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwN+Ispxjp7qNj5XT5FeX\r\n" + 
			"1VAPAp68s3hgukR08+AeNzxnGhqX/h0KEnRN2khg/bK6qTFI1wYy3QZk8ptUBrqC\r\n" + 
			"dLlLBSVPn44WWKQfebt4EqSQlG25C91dav+NCUNldO2HW4DgXWvt+B/pKAtReJ+q\r\n" + 
			"h3AANYA709zbFirwhRW2mkQRQO8bOArL9c0z8iAhuVbm/VgB3lpGPnA6tAV7e3vl\r\n" + 
			"NJ23IlngHJNDEv/MljOwPcaiWPTZ2+D6DAqsvgRP1EBCyadZ5sNJu3mlSVGy6LNo\r\n" + 
			"wjEMl+gtiyiHN3cft9x3JnOK5tO0VwUUy6UF1ewtjZnke5MYdm6y/+3Hj6sVwiR6\r\n" + 
			"lwIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
