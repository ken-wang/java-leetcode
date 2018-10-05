package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {

		int length = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			length += word.length();
			map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
		}

		if (s.length() < length) {
			return new ArrayList<>();
		}

		Set<Integer> indexes = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			for (int index = s.indexOf(words[i]); index >= 0; index = s.indexOf(words[i], index + 1)) {
				Map<String, Integer> _map = new HashMap<>();
				_map.putAll(map);
				_map.put(words[i], _map.get(words[i]) - 1);

				String sub = s.substring(index + words[i].length());
				String temp = "";
				for (int j = 0; j < sub.length(); j++) {
					temp = temp + sub.charAt(j);
					if (_map.containsKey(temp) && _map.get(temp) > 0) {
						_map.put(temp, _map.get(temp) - 1);
						temp = "";
					}
				}

				if (_map.entrySet().parallelStream().filter(entry -> entry.getValue() != 0).count() == 0) {
					indexes.add(index);
				}

			}

		}

		return indexes.parallelStream().collect(Collectors.toList());

	}

	public List<Integer> findSubstring2(String s, String[] words) {

		int length = 0;
		for (String word : words) {
			length += word.length();
		}

		if (s.length() < length) {
			return new ArrayList<>();
		}

		Set<Integer> indexes = new HashSet<>();
		for (int i = 0; i < words.length; i++) {

			for (int index = s.indexOf(words[i]); index >= 0; index = s.indexOf(words[i], index + 1)) {
				String[] _words = new String[words.length - 1];

				for (int j = 0; j < i; j++) {
					_words[j] = words[j];
				}

				for (int j = i + 1; j < words.length; j++) {
					_words[j - 1] = words[j];
				}

				if (isSubString(s.substring(index + words[i].length()), _words)) {
					indexes.add(index);
				}
			}

		}

		return indexes.parallelStream().collect(Collectors.toList());

	}

	private boolean isSubString(String s, String[] words) {

		if (words.length == 0) {
			return true;
		}

		if (words.length == 1) {
			return s.startsWith(words[0]);
		}

		for (int i = 0; i < words.length; i++) {
			if (s.startsWith(words[i])) {
				String[] _words = new String[words.length - 1];

				for (int j = 0; j < i; j++) {
					_words[j] = words[j];
				}

				for (int j = i + 1; j < words.length; j++) {
					_words[j - 1] = words[j];
				}

				return isSubString(s.substring(words[i].length()), _words);

			}

		}
		return false;
	}

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
		// System.out.print("[");
		// obj.findSubstring("a", new String[] { "a" }).forEach(index ->
		// System.out.print(index + ", "));
		// System.out.println("]");
		//
		// System.out.print("[");
		// obj.findSubstring("hello", new String[] { "l", "lo", "he" }).forEach(index ->
		// System.out.print(index + ", "));
		// System.out.println("]");

		System.out.print("[");
		obj.findSubstring2("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" })
				.forEach(index -> System.out.print(index + ", "));
		System.out.println("]");

		System.out.print("[");
		obj.findSubstring2("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" })
				.forEach(index -> System.out.print(index + ", "));
		System.out.println("]");

		long before = System.currentTimeMillis();
		System.out.print("[");
		obj.findSubstring2(
				"aratdgpfsookqyxiptwjllwirwmfdmafdayignqadektejbvcaepnbyezmlcalkfnkovaeydkixqsalwaqmptmwsajwaxifktvitbgwlqvdiwphyhtochmwhvujsdofymptnvpzlnewjtfhcaxghjeqhzzzepgebvxpqoqebuckqhuuhtbqdfgmghlmwuqypppiefofbqsrzooihpymwgyfnmrlgkjxzaffftnjlfamvoucfurecpjpdcblomjqnovukidvpgikwepebgidxttdxwomkzczqxuaizxxhfkembinjsqglllijcwubytryptgrrfyypekqmxzeqirbvclxyhbxcuxuodlfilfaqqsepulfecjzgwzfdaehubbkeorocxqunjycflkjqtkwpjbsjfbggdqmtibvhtpucqyjbisrbfosopmaxogdryqmitkpmzlrrkatuvmyaaqosdqpryukxkwhfgzuiklzwnurkhpkjfbbirsbqnlpzkyfsxbcimeebyxmhmyruzsctlglytaxfyeyyfcgtgmxfkjowjfqjyveldplwricppcnwevsnkpuuaisjoluoiyzlnkjeulwlpliujahtrdntlhczsxncxonlyxrvkngabowkqffjiuctbhvweiybxmoxlisvvzxyptkiyprijwcndxjjhhmgvbeijwegvdhnxrvxjoiskmfnloysylzvmfexbifznmmmgjkpxujkgpzrfyjfjkbxpfwtpbscqgpwrbnovwadlautyfahqbehiccxdwctcrrvuekrbkuokojktkrlnxvwzxtfuvayosuiygzzstqfjzpfljszinvilqphopfejzpihqjamzfvbuamftloiiyvbncrekvolkytbhtnjakkulwagkqquomvbomhykvkuvdxdykoyvyuiwwqgmgdasydjnlhxitreyrjwbxwyxritnacahfcbdgksrupzpjfoaomdnjekamepngpwlsxqakjrgasvjyjlowpcftohhuwwaounisgiepbkpthbtrmipbmuwcdgxzczpxnxrthxkijbeqcxhphysvuryxzxzbwoalmtgvsqedsiuwhdlrcgmwzmuyjvbijetxzatsszvmjrjqvwhzeuvdirbumdcyhxvizqaspygyprrmoyluuhyfabzpgbnpykyadasuyavosmaimocjxcoxgnooqdeqqeqtekpflktfyvnllruiwigexwsnaydqcwljgaotljyjgnwshsafaijzfdmfcsvgogruifovqohxcdrjwroyazyfcmmgejpsrgnzodvercdtfuedoueotcvyqhgvsvnjeciuhfazheupabuovycrczptixoatdlziutpbtqjzlaamuojvtaxsrsdpidkmplulejmzcxznzbbupkrinqdgjgvrlhdcsznylcynbzcbadxppoaeedlplihwqmzkoojbqjouksvkvubmidtoiegtonqgbrrrfcsynisxanjxhkmrqfhylnszckigbbxgdqeqawpblyyukmlarvzcitelfmtgnqosivkjtzmfxmzjznkqilvsgzflnytcpjwzegkyfwfejgnivzadkvyswdflcyptilsmrdmybrckasuvrxzeszyrceeecuxmfsbxxnvyhalhuhcnedrzcsqfwulyqlnwdovcbsaksnrmvwczztyelqljnwkdhxzmlwooprzheqwzoyzotzuhsfqfbailzkzkgobxfaflsdlhdmxylrhdwykzavkchkmpannhpuskxdrcrocfhkkdkvemqrozddodsbmivesuklybbbgintnxorjgiafldvqxxcfujzptmnwnqfxdymcoemwoobcrwuovxwqgxfbmuzznezselvsrhoivrmoqgeldcdlakomfonuuomzahttqkdndpdvwihzkknmxbaeroymcmneuiamudaytftpncqapdmmhnqadomhcbmwkmlgrneksazicqitvwfelxfontyqvkohyznrmuchubpytxsrvzvhxaxmuvcrhryhsnzfhbmdedcacwrxxmeupejjzlcjeaqxprexssazvezxaquyebuthdegrgrviisybwxuozvleuiemfeqizmpeqxvzprjzljakguagrmmlwszdxqlyeacuyavnrfmeomqxjrfcfrqbjpfihsgltlitldiekwibkzavsfyxyoajdhsnaayvliqyoycyunbgobcggcfgqhqvpkirkjmytcwhcbiyojeelimtkracysypcigotuopynwaoeyeqfibnuwynwcnqcdsnljggxxemuhaafgskovaksyzqcnhfsbsdkalkyswuzzugfnrwiricritvvaandssoveatwynxxjdfywbjpllitgeoiedmzwcwccpyaexapafqzizotmxntddbjhnifrghtxhwdewtgblfjkwcyvrravvjeiujaasvyzrbfnwlqhtbrrgqoxjouexyprjrsdmscgtjvqxoxsprjvjzvunpzkqqebhyfvqjdjtzbspbkeuvcduxxhoytgoxkvvptnawxvxanmbzrvuvaouavkyprpobkmsfzucyqzzfoafhyzcaoyalizczorcafuiepkdhlcmberietmfhkhutgxuwqxzvthbktergieipxqvqfazpiuiqrdphcqevzfgsmzaudildbhtgjvvtpgmglbpptvksasmosmlxvwawfweprbkghwouzfjsawmcqyrilcggaieggkxzlhhvgvrfcbaczmhpnayyeggeqmkzwjyjrgezdwegzgkytrpgtpgxxmcoaopwynhrtmqzkwfjdrjylageqocncgdcusaughnbtfcfchqhbbhmcpssduhfaljxdjtlqhpmmrrqbkzcliqnxihcfpjhcsehdatwhkivbboennizwyovjwyonhvpccyfctbldlghpulckwdgusbfobtdlruntsuvmyiplowalkfvgibcaeiqgdvrupgnickwasnmjkouwvpegsgiwqbeuwxoofeyiquijhwutnorkfvqxezvuaaoyzfmfjknzgxkowgjlubvzwoycnuxpwnnvsccdorfvprlnyuyuvvuujswyovpkjdidhkjveoqvfbifyiatfuproopflfpukzarmjmqxfleivkgdkckgrbwhtbtytpkspdeyruxwhefcqlhcnsihvgookjodzyxodcpvyorisykimukboukjdbankosjppastpnufhcyhoivivxwphisiihvwzenregkvvebcgbmxlhfggewomqywatsbagsgodcjjfosiaptjwcqaagoseksafuanoibrmmdtavbcmxmizcjzizrokmqrgseubhontrhwokyahmiiqthyvbpfnfwvycrzjhmeyvaogboppzyguhgpkvwxbuuzwmahtomukoksrbhhafnwptozpkzshttdhtndhzztpjlhkvomadlrwzrnlsfsnayxtladmbybkmixhyjjbwbavunjmvbzvbwrmywyzwcmikjplszmrammwcvizzjwagpngnngkpsscbinvjbmjqbfsyptxyraghpnueveupxyshlpqoebehiyfxtfxlfeswtoaqtwhsuzzhqrwuscbabjxuqwfxaztvotnjqubmtcuktsgnuknxvmulkbilbbirwwaoqdbmhxycrgpnqellshycigpjjycgwcumhxaowysnfhbxnolhvjkdqbpzbthxycmfbmwynonsyqpleatbmfhcgydkrlhpnvxqktoxjerhugvzjqcvxjzfhcpbnzqcupteijdunudkdyjmqnjnxkvgmkhcjaegpzmalquakxknyvbojmeiwzollynvytdpvrpghlgulthjolzxxdfwewhquwnupslmjbsroblzuuikhkkfnrbunkmjgzfxrrkcuctifgibdqmkcwrsnumdeyokzukqlushyopgwxhzqtmsrdkhyykewyrvubnhxiovwebudjwveioynafnzrsxrltmmitjqkgooiltthpzrdzefeuexocpzxbnhwyageowozqjihjzmigrpaymqcdpzgcidailgxkvyaejjpivaqmpskdimhznnbwsdegmdqheqnnzfxwfqiwivbthksxawvsbbynhowlgmahrzdypouajvtsilpihkajobwvrviyhihyjnwbbsbmpuexhufpgiaujyratzachkctzauasvmkrsjaoprxzrrislklknqszsnythaneoxxghxvypsxilhawtohiebhyqhrxhhdvgaepzbnqvmzgtbfppoxvrfuhongwujtblxqmygdtsecofjdxxasqhoxwcfuyqnbbnuplashuyjiesnbrqvhzkgxmlrmbhoeuithiooeoznstcvmsttsdbrrojdrsrvmbrtlhkqvlfqfhnrcgnulqlcfwiwobucdnyowketvjlctzuvhjrtzexedfdrhzwkmuakghdbsrelsaibjzukeuphzuaityuhuvtaeyewpiihkqjtsfdybufbqhlliiucdndjmhfdrpnbgwwadzyfwfimovawduziierwlxzemmfukbuocsvyzfnoankejjmrnepadpepdjkomgepbzpageogtzkdizwydmyiddxgojubqystzhtfmiofhykrzhpevomytkehvbknbcgdmakyiyfrzsiybadwqpwjzcsxdfkhhrkvtuvbtdssvcqwcvuslqdmsyjydufmnrigldjggdadftzkotezlimeixeltjxgahonlxwtcwxkpyuguaffktlsrpdmydtakjqxjmtliqxaqrgkunqejbxctcorhjustkrewkpgcngtgodcevhpzgrskhlsrfmmrdqpqhwswelfvrhzoqonyhhjotbhaptusljivfbrmoyhhigwywlxdtirojzoyuisiuddbgwnuxwefccdapcdkkxyvyptszoctrfvxektbhzilblororbyqcworpjqflmwtjvztpacqkqsvellvommqiajzlafxodqxbpqsrviblaypnkmeyyugbehmgolwsbtvslnjgvkrylinvvrvvmbwsilazwwraroscbejyqcwblkygdtbrualfnleljxlclgfokqmaslefxclawpssrdzerdrccffplkdxaszuddaainaeeswvywbpbvtgayvnkbkmtlhwrjyzyyddtbatzcidxbjzcgmmjyzejicarabpbeuuivphxxkwavvcejrnhqusawvrxwiyddulyjuxifvkcspgbgwkyqeamzrlyblbghogsifapansscavkwfkokkdldojgcmnjavclbeabrswvvrhtzrildlwgbindwcpzxrkyvkcpfykarutslbdpocxskkxgomfmfrmbcoshmehgyaymecbueamqlmybygnexahzobidfplgsjsynvstvhlitkktszzpzirqjbvptgxlrplhkfahmoqhaadszcjblctweonxwkkpzxwlcztrnjynldhmiqnvvgrzwfyurkkthgejhzawkbjxeskolxjggbheihzzrjsarzjbymxlpjivbskostuaudeckfedowdivplwbihqtpnxixlcricllgqymubcsfmowxkzirrbieaqcmstuwgffwdrshvlokbkjnjtgaxogxhijbbfyildgqwbzrondpznckiimfytdfbmhfsfpfkvxgyxzmmddosfyaplgqelvhzemtjbatzybxxbmlgpzyxyaoliertcytgnosoplppppmqbzwszwpzygmhkdcmdxtqmlhbywqpnefqddjebadagpjtulhyjaovnxyowodjulaxolcsnhsuzbptowtxziuohscdiinctpcjagbnnvjoyaknxdkynfmvzryiznmscodewfumafazgmodsydhfpcfgdpfsdzxudbqkvcmbdnjrbmjarrhgvonafut",
				new String[] { "vkyprpobkmsfzucyqzzfoafhyzca", "gdvrupgnickwasnmjkouwvpegsgi",
						"jzukeuphzuaityuhuvtaeyewpiih", "syzqcnhfsbsdkalkyswuzzugfnrw", "kygdtbrualfnleljxlclgfokqmas",
						"pqoqebuckqhuuhtbqdfgmghlmwuq", "ycrgpnqellshycigpjjycgwcumhx", "vgogruifovqohxcdrjwroyazyfcm",
						"lefxclawpssrdzerdrccffplkdxa", "vyqhgvsvnjeciuhfazheupabuovy", "fexbifznmmmgjkpxujkgpzrfyjfj",
						"qthyvbpfnfwvycrzjhmeyvaogbop", "rvvmbwsilazwwraroscbejyqcwbl", "jzlafxodqxbpqsrviblaypnkmeyy",
						"vrhzoqonyhhjotbhaptusljivfbr", "trfvxektbhzilblororbyqcworpj", "sybwxuozvleuiemfeqizmpeqxvzp",
						"bxgdqeqawpblyyukmlarvzcitelf", "tjxgahonlxwtcwxkpyuguaffktls", "ebhyfvqjdjtzbspbkeuvcduxxhoy",
						"rplhkfahmoqhaadszcjblctweonx", "obxfaflsdlhdmxylrhdwykzavkch", "hykrzhpevomytkehvbknbcgdmaky",
						"tuvbtdssvcqwcvuslqdmsyjydufm", "bkmtlhwrjyzyyddtbatzcidxbjzc", "nrigldjggdadftzkotezlimeixel",
						"tjqkgooiltthpzrdzefeuexocpzx", "astpnufhcyhoivivxwphisiihvwz", "plashuyjiesnbrqvhzkgxmlrmbho",
						"ieaqcmstuwgffwdrshvlokbkjnjt", "dewtgblfjkwcyvrravvjeiujaasv", "hzeuvdirbumdcyhxvizqaspygypr",
						"bbupkrinqdgjgvrlhdcsznylcynb", "mwzmuyjvbijetxzatsszvmjrjqvw", "lsxqakjrgasvjyjlowpcftohhuww",
						"datwhkivbboennizwyovjwyonhvp", "stuaudeckfedowdivplwbihqtpnx", "chkctzauasvmkrsjaoprxzrrislk",
						"sypcigotuopynwaoeyeqfibnuwyn", "izwydmyiddxgojubqystzhtfmiof", "rsrvmbrtlhkqvlfqfhnrcgnulqlc",
						"tmfhkhutgxuwqxzvthbktergieip", "kmpannhpuskxdrcrocfhkkdkvemq", "pvyorisykimukboukjdbankosjpp",
						"fahqbehiccxdwctcrrvuekrbkuok", "nuuomzahttqkdndpdvwihzkknmxb", "agpngnngkpsscbinvjbmjqbfsypt",
						"zcbadxppoaeedlplihwqmzkoojbq", "bgwnuxwefccdapcdkkxyvyptszoc", "xzeszyrceeecuxmfsbxxnvyhalhu",
						"evhpzgrskhlsrfmmrdqpqhwswelf", "euithiooeoznstcvmsttsdbrrojd", "ibdqmkcwrsnumdeyokzukqlushyo",
						"babjxuqwfxaztvotnjqubmtcukts", "kqjtsfdybufbqhlliiucdndjmhfd", "csynisxanjxhkmrqfhylnszckigb",
						"dtsecofjdxxasqhoxwcfuyqnbbnu", "owkqffjiuctbhvweiybxmoxlisvv", "kbxpfwtpbscqgpwrbnovwadlauty",
						"nepadpepdjkomgepbzpageogtzkd", "mmhnqadomhcbmwkmlgrneksazicq", "rjgiafldvqxxcfujzptmnwnqfxdy",
						"tgoxkvvptnawxvxanmbzrvuvaoua", "oyalizczorcafuiepkdhlcmberie", "wcnqcdsnljggxxemuhaafgskovak",
						"tfcfchqhbbhmcpssduhfaljxdjtl", "gdryqmitkpmzlrrkatuvmyaaqosd", "zmhpnayyeggeqmkzwjyjrgezdweg",
						"qflmwtjvztpacqkqsvellvommqia", "rbhhafnwptozpkzshttdhtndhzzt", "kqmxzeqirbvclxyhbxcuxuodlfil",
						"epnbyezmlcalkfnkovaeydkixqsa", "crczptixoatdlziutpbtqjzlaamu", "avclbeabrswvvrhtzrildlwgbind",
						"jbxctcorhjustkrewkpgcngtgodc", "xwhefcqlhcnsihvgookjodzyxodc", "vgmkhcjaegpzmalquakxknyvbojm",
						"pjlhkvomadlrwzrnlsfsnayxtlad", "rzheqwzoyzotzuhsfqfbailzkzkg", "pbnzqcupteijdunudkdyjmqnjnxk",
						"zxxdfwewhquwnupslmjbsroblzuu", "zselvsrhoivrmoqgeldcdlakomfo", "qjamzfvbuamftloiiyvbncrekvol",
						"xyowodjulaxolcsnhsuzbptowtxz", "puuaisjoluoiyzlnkjeulwlpliuj", "dpzgcidailgxkvyaejjpivaqmpsk",
						"mfbmwynonsyqpleatbmfhcgydkrl", "qhpmmrrqbkzcliqnxihcfpjhcseh", "pflktfyvnllruiwigexwsnaydqcw",
						"mdedcacwrxxmeupejjzlcjeaqxpr", "bnhwyageowozqjihjzmigrpaymqc", "njsqglllijcwubytryptgrrfyype",
						"moyhhigwywlxdtirojzoyuisiudd", "gaxogxhijbbfyildgqwbzrondpzn", "qpryukxkwhfgzuiklzwnurkhpkjf",
						"rjzljakguagrmmlwszdxqlyeacuy", "eivkgdkckgrbwhtbtytpkspdeyru", "ikhkkfnrbunkmjgzfxrrkcuctifg",
						"sdmscgtjvqxoxsprjvjzvunpzkqq", "mywyzwcmikjplszmrammwcvizzjw", "ixlcricllgqymubcsfmowxkzirrb",
						"ahtrdntlhczsxncxonlyxrvkngab", "lruntsuvmyiplowalkfvgibcaeiq", "wqpnefqddjebadagpjtulhyjaovn",
						"eiwzollynvytdpvrpghlgulthjol", "tqfjzpfljszinvilqphopfejzpih", "gnuknxvmulkbilbbirwwaoqdbmhx",
						"ypouajvtsilpihkajobwvrviyhih", "smlxvwawfweprbkghwouzfjsawmc", "uvvuujswyovpkjdidhkjveoqvfbi",
						"vyswdflcyptilsmrdmybrckasuvr", "avnrfmeomqxjrfcfrqbjpfihsglt", "rpdmydtakjqxjmtliqxaqrgkunqe",
						"pmqbzwszwpzygmhkdcmdxtqmlhby", "vvcejrnhqusawvrxwiyddulyjuxi", "aounisgiepbkpthbtrmipbmuwcdg",
						"nlhxitreyrjwbxwyxritnacahfcb", "wivbthksxawvsbbynhowlgmahrzd", "zxyptkiyprijwcndxjjhhmgvbeij",
						"zgkytrpgtpgxxmcoaopwynhrtmqz", "zgtbfppoxvrfuhongwujtblxqmyg", "kvkuvdxdykoyvyuiwwqgmgdasydj",
						"jouksvkvubmidtoiegtonqgbrrrf", "yjnwbbsbmpuexhufpgiaujyratza", "zflnytcpjwzegkyfwfejgnivzadk",
						"eksafuanoibrmmdtavbcmxmizcjz", "qyrilcggaieggkxzlhhvgvrfcbac", "ayvliqyoycyunbgobcggcfgqhqvp",
						"wqbeuwxoofeyiquijhwutnorkfvq", "lgkjxzaffftnjlfamvoucfurecpj", "yxzxzbwoalmtgvsqedsiuwhdlrcg",
						"pdcblomjqnovukidvpgikwepebgi", "lwaqmptmwsajwaxifktvitbgwlqv", "zlnewjtfhcaxghjeqhzzzepgebvx",
						"jowjfqjyveldplwricppcnwevsnk", "hcnedrzcsqfwulyqlnwdovcbsaks", "kwfjdrjylageqocncgdcusaughnb",
						"mlgpzyxyaoliertcytgnosoplppp", "nvstvhlitkktszzpzirqjbvptgxl", "ccyfctbldlghpulckwdgusbfobtd",
						"faqqsepulfecjzgwzfdaehubbkeo", "dgksrupzpjfoaomdnjekamepngpw", "dosfyaplgqelvhzemtjbatzybxxb",
						"bbirsbqnlpzkyfsxbcimeebyxmhm", "kirkjmytcwhcbiyojeelimtkracy", "yruzsctlglytaxfyeyyfcgtgmxfk",
						"fxtfxlfeswtoaqtwhsuzzhqrwusc", "xzczpxnxrthxkijbeqcxhphysvur", "itvwfelxfontyqvkohyznrmuchub",
						"fwiwobucdnyowketvjlctzuvhjrt", "awtohiebhyqhrxhhdvgaepzbnqvm", "mbybkmixhyjjbwbavunjmvbzvbwr",
						"ywbjpllitgeoiedmzwcwccpyaexa", "pgwxhzqtmsrdkhyykewyrvubnhxi", "iricritvvaandssoveatwynxxjdf",
						"zexedfdrhzwkmuakghdbsrelsaib", "ypppiefofbqsrzooihpymwgyfnmr", "lknqszsnythaneoxxghxvypsxilh",
						"rocxqunjycflkjqtkwpjbsjfbggd", "qmtibvhtpucqyjbisrbfosopmaxo", "nrmvwczztyelqljnwkdhxzmlwoop",
						"vosmaimocjxcoxgnooqdeqqeqtek", "exssazvezxaquyebuthdegrgrvii", "yzrbfnwlqhtbrrgqoxjouexyprjr",
						"hpnvxqktoxjerhugvzjqcvxjzfhc", "ifapansscavkwfkokkdldojgcmnj", "gmmjyzejicarabpbeuuivphxxkwa",
						"mtgnqosivkjtzmfxmzjznkqilvsg", "aeroymcmneuiamudaytftpncqapd", "ovwebudjwveioynafnzrsxrltmmi",
						"litldiekwibkzavsfyxyoajdhsna", "wkkpzxwlcztrnjynldhmiqnvvgrz", "szuddaainaeeswvywbpbvtgayvnk",
						"kkxgomfmfrmbcoshmehgyaymecbu", "dimhznnbwsdegmdqheqnnzfxwfqi", "xqvqfazpiuiqrdphcqevzfgsmzau",
						"eamqlmybygnexahzobidfplgsjsy", "pytxsrvzvhxaxmuvcrhryhsnzfhb", "wegvdhnxrvxjoiskmfnloysylzvm",
						"xezvuaaoyzfmfjknzgxkowgjlubv", "pafqzizotmxntddbjhnifrghtxhw", "lxzemmfukbuocsvyzfnoankejjmr",
						"rpnbgwwadzyfwfimovawduziierw", "rozddodsbmivesuklybbbgintnxo", "izrokmqrgseubhontrhwokyahmii",
						"ojvtaxsrsdpidkmplulejmzcxznz", "diwphyhtochmwhvujsdofymptnvp", "dildbhtgjvvtpgmglbpptvksasmo",
						"rmoyluuhyfabzpgbnpykyadasuya", "ojktkrlnxvwzxtfuvayosuiygzzs", "ugbehmgolwsbtvslnjgvkrylinvv",
						"mcoemwoobcrwuovxwqgxfbmuzzne", "aowysnfhbxnolhvjkdqbpzbthxyc", "mgejpsrgnzodvercdtfuedoueotc",
						"fyiatfuproopflfpukzarmjmqxfl", "zwoycnuxpwnnvsccdorfvprlnyuy", "ckiimfytdfbmhfsfpfkvxgyxzmmd",
						"kytbhtnjakkulwagkqquomvbomhy", "dxttdxwomkzczqxuaizxxhfkembi", "fvkcspgbgwkyqeamzrlyblbghogs",
						"wcpzxrkyvkcpfykarutslbdpocxs", "enregkvvebcgbmxlhfggewomqywa", "iyfrzsiybadwqpwjzcsxdfkhhrkv",
						"wfyurkkthgejhzawkbjxeskolxjg", "xyraghpnueveupxyshlpqoebehiy", "gbheihzzrjsarzjbymxlpjivbsko",
						"pzyguhgpkvwxbuuzwmahtomukoks", "tsbagsgodcjjfosiaptjwcqaagos",
						"ljgaotljyjgnwshsafaijzfdmfcs" })
				.forEach(index -> System.out.print(index + ", "));
		System.out.println("]");
		System.out.println("time:" + (System.currentTimeMillis() - before));

	}

}
