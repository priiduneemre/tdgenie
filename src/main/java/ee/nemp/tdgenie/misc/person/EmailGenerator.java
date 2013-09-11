package ee.nemp.tdgenie.misc.person;

import ee.nemp.tdgenie.misc.MiscGenerator;
import ee.nemp.tdgenie.text.AlphaNumericStringGenerator;
import ee.nemp.tdgenie.text.TextGenerator;

public class EmailGenerator extends MiscGenerator<String>{
	
	//Constants
	public static final int USERNAME_MIN_LENGTH = 2;
	public static final int USERNAME_MAX_LENGTH = 15;
	public static final int DOMAIN_NAME_MIN_LENGTH = 2;
	public static final int DOMAIN_NAME_MAX_LENGTH = 15;
	public static final String[] LEGAL_DOMAIN_EXTENSIONS = new String[]{
			"bitnet", "ac", "ad", "ae", "af", "ag", "ai", "al", "am", "an", "ao", "aq",
			"ar", "as", "at", "au", "aw", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh",
			"bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca",
			"cc", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "com", "cr", "cs",
			"cu", "cv", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "edu",
			"ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "fx",
			"ga", "gb", "gd", "ge", "gf", "gh", "gi", "gl", "gm", "gn", "gov", "gp", "gq",
			"gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id",
			"ie", "il", "in", "io", "iq", "ir", "is", "it", "jm", "jo", "jp", "ke", "kg",
			"kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li",
			"lk", "lr", "ls", "lt", "lu", "lv", "ly", "mc", "md", "mg", "mh", "mil", "mk",
			"ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "museum", "mv",
			"mw", "mx", "my", "mz", "na", "nc", "ne", "net", "nf", "ng", "ni", "nl", "no",
			"np", "nr", "nt", "nu", "nz", "om", "org", "pa", "pe", "pf", "pg", "ph", "pk",
			"pl", "pm", "pn", "pr", "pt", "pw", "py", "qa", "re", "ro", "ru", "rw", "sa",
			"sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so",
			"sr", "st", "su", "sv", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk",
			"tm", "tn", "to", "tp", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "uk", "um",
			"us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye",
			"yt", "yu", "za", "zm", "zr", "zw"};
	
	//Instance variables
	private TextGenerator<String> alphaNumericGen;
	
	
	public EmailGenerator(){
		alphaNumericGen = new AlphaNumericStringGenerator();
	}
	
	@Override
	public String getRndValue() {
		StringBuilder rndEmail = new StringBuilder();
		
		String rndUserName = alphaNumericGen.setMinLength(USERNAME_MIN_LENGTH).
				setMaxLength(USERNAME_MAX_LENGTH).generateValues(1).get(0);
		String rndDomainName = alphaNumericGen.setMinLength(DOMAIN_NAME_MIN_LENGTH).
				setMaxLength(DOMAIN_NAME_MAX_LENGTH).generateValues(1).get(0);
		String rndDomainExt = LEGAL_DOMAIN_EXTENSIONS
				[getRndSeed().nextInt(LEGAL_DOMAIN_EXTENSIONS.length)];

		rndEmail.append(rndUserName + "@" + rndDomainName + "." + rndDomainExt);
		
		return rndEmail.toString();
	}
}