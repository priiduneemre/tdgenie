package ee.nemp.tdgenie.misc.person;

public class LastNameGenerator extends NameGenerator {

	//Constants
	public static final String[] LAST_NAME_ASSORTMENT = new String[]{"Aaberg","Abercombie",
		"Adelsberg","Agoff","Albarado","Aleshire","Allgire","Alstrom","Amorim","Andreola",
		"Antonakos","Antrikin","Aranas","Armen","Arriaga","Atcitty","Aul","Awtrey","Babiracki",
		"Badgett","Bajaj","Balfe","Barajas","Bargar","Barthen","Baskow","Bayley","Beaudette",
		"Beeck","Behun","Belle","Bencosme","Bens","Bernhart","Besancon","Biard","Bierner","Bigford",
		"Bisagna","Blackgoat","Blizard","Boals","Boehme","Bohnen","Bonillas","Bordenkircher",
		"Botos","Bottolene","Boutin","Bragado","Branner","Brenagh","Brickley","Briski","Brodsho",
		"Brosman","Brzostowski","Brumit","Bukowinski","Buol","Burrington","Bustamante","Cader",
		"Caldon","Camberos","Canale","Cantoral","Carasquillo","Carlberg","Carvin","Cassata",
		"Cavagnaro","Cella","Centrella","Chandra","Chatfield","Child","Chollett","Churchill",
		"Cinotti","Cleveland","Clynes","Colcord","Colestock","Coma","Constine","Copper","Cory",
		"Coughenour","Coxon","Cravy","Cribari","Crooker","Cruse","Czajkowski","Currey","Dalphonse",
		"Danni","Davidowicz","Debarba","Dedeaux","Degelbeck","Dejulio","Delgoda","Delrie","Denny",
		"Derenzis","Deter","Dewaratanawan","Devivo","Dietzen","Dilts","Divenere","Doepner","Domio",
		"Dopler","Dozier","Driesenga","Duell","Duewall","Dunay","Duston","Eafford","Edgley",
		"Ehleiter","Ekis","Ellenbogen","Elting","Engdahl","Enzenauer","Esperanza","Etter",
		"Fagerstrom","Falley","Faulknen","Fedele","Felli","Ferdin","Fertitta","Figueron",
		"Finkenbiner","Fleisher","Floth","Foringer","Fote","Fournier","Frediani","Frew","Fugett",
		"Furino","Gaeddert","Galgano","Gantner","Garner","Gauntlett","Gavel","Gehlhausen","Gerety",
		"Getman","Gilding","Gingles","Gladhart","Glise","Godbe","Goldenberg","Gonda","Gotcher",
		"Grabinski","Gravit","Greife","Grogg","Gruis","Guerera","Guillermo","Gunselman","Guziczek",
		"Haddan","Halleck","Hamiss","Hansing","Hardrict","Hargroder","Harvest","Hatmaker","Heagney",
		"Hedrix","Heines","Hellings","Henshall","Herndon","Heziak","Hickam","Hiler","Hirschi",
		"Hochstetter","Holdren","Holshouser","Honza","Horner","Hostert","Howorth","Hudley",
		"Huppenbauer","Hutti","Illian","Inks","Jabaay","Jamal","Jarosh","Jeanmard","Jerding",
		"Joerling","Josilowsky","Kadis","Kaley","Kapp","Kartman","Kasik","Keasler","Keisler",
		"Kerkhoff","Kew","Kiger","Kimoto","Kisro","Klaver","Kluttz","Knaggs","Knotek","Kolehmainen",
		"Koogle","Kotrys","Krack","Kreke","Krofft","Krusemark","Kufeldt","Kunkel","Labore","Lady",
		"Lamark","Lana","Lapadula","Laroche","Latina","Laur","Lawary","Leathers","Lee","Lekwa",
		"Lenoch","Levans","Li","Libre","Linard","Links","Llopis","Loescher","Londre","Loren",
		"Lowenthal","Luckhardt","Lupton","Lusignan","Lyster","Macneill","Maes","Maj","Malet",
		"Manasco","Maniar","Mantanona","Marchese","Marine","Martinet","Mashni","Matsuda","Mauras",
		"Mccadams","Mcclard","Mccraight","Mcdermett","Mcgarraugh","Mchale","Mckimmy","Mcquerry",
		"Meas","Meland","Membreno","Mendelowitz","Mersereau","Mettenburg","Mikels","Milleson",
		"Minick","Mischler","Mogren","Moltrie","Montierth","Montrella","Morella","Mossien","Moyet",
		"Munger","Murrow","Myree","Najera","Narcisse","Nazario","Neihart","Newitt","Nicolai","Niver",
		"Noonan","Nuesca","Obanion","Odgen","Ogeen","Okoye","Olp","Opoien","Osen","Otiz","Pacifico",
		"Pajerski","Palazzo","Paola","Parham","Pate","Pavelka","Pecina","Pelfrey","Peressini",
		"Perschbacher","Pezina","Petway","Phillippi","Piganelli","Pinger","Plasse","Plumer","Polcyn",
		"Pompilio","Porada","Pouch","Prazenica","Prodan","Pruskowski","Putnam","Quercia","Radona",
		"Rainone","Ramthun","Rapone","Rattigan","Reagans","Redeker","Reining","Renault","Rexroad",
		"Ricciardi","Richeson","Rijo","Ripple","Rocha","Rodrigus","Rokosz","Ronco","Rote","Rovira",
		"Ruffin","Ruggles","Ruschel","Sabal","Saffell","Saltonstall","Samul","Sanna","Sar","Sarullo",
		"Savini","Scantlen","Schembri","Schindel","Schnieders","Schoppert","Schweer","Scorsone",
		"Seaward","Seekins","Sekerak","Senion","Sert","Shands","Shealey","Shiers","Shisila",
		"Shoemate","Sibbett","Sienicki","Sinard","Sise","Skenandore","Slappy","Smolko","Sobol",
		"Song","Sonoski","Souhrada","Spenard","Spitsberg","Szweda","Stagowski","Standlee","Stathis",
		"Stefanelli","Steinlicht","Steudeman","Stinar","Storniolo","Stratos","Strutynski",
		"Stutesman","Suns","Sweis","Svetlak","Swyers","Zaleski","Zekria","Zic","Zuchowski",
		"Takehara","Tanh","Tazelaar","Telle","Teves","Thessing","Thiede","Tichy","Timoteo","Toline",
		"Tonrey","Tortora","Trachte","Tribe","Trojak","Tucay","Tuell","Turley","Uhlenhopp","Unser",
		"Wadzinski","Waldbauer","Valdovinos","Waltz","Vanbecelaere","Vandeweert","Vanlier",
		"Vantrease","Warens","Wassermann","Vasseur","Weckenborg","Weigman","Velez","Werle",
		"Westra","Vevea","Whitsey","Widrick","Wiedman","Vigilo","Willette","Wind","Viste",
		"Witkowski","Voitier","Wojtczak","Woodland","Woyahn","Yandura","Yeiser","Yuen","Yuricic"};
	
	
	@Override
	public String[] getNameAssortment() {
		return LAST_NAME_ASSORTMENT;
	}
}