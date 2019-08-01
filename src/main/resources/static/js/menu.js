var carModels = {
	"Alfa-Romeo" : [ "147","156","159","166","Giulietta" ],
	Audi : [ "A1","A2","A3", "A4","A5","A6","A6 Allroad", "A7" ,"A8","Q5","Q7","TT"],
	BMW : ["Seria 1","Seria 3", "Seria 5", "Seria 6","Seria 7","X1","X3","X5"],
	Chevrolet : ["Aveo","Captiva","Cruze","Kalos","Lacetti","Spark"],
	Chrysler : ["300C","Grand Voyager"],
	Citroen : ["C1","C2","C3","C3 Picasso","C4","C4 Picasso","C5","C6","C8","Nemo","Saxo","Xantia"],
	Dacia : [ "1300","1310","Logan", "Duster", "Sandero" ],
	Daewoo : ["Cielo","Matiz","Nubira"],
	Daihatsu : ["Sirion","Terios"],
	Dodge : ["Avenger","Caliber","Challenger","Charger","Nitro","Ram"],
	Fiat : ["Albea","Bravo","Croma","Doblo","Ducato","Grande Punto","Linea","Punto","Panda","Qubo","Scudo","Sadici","Stilo","Tipo"],
	Ford : ["Fiesta","Focus","Fusion","Galaxy","Ka","Kuga","Mondeo","S-Max","Streetka","Transit"],
	Honda : ["Accord","Civic","CR-V","Insight","Jazz"],
	Hyundai : ["Accent","Coupe","Elantra","Galloper","Getz","h-1","i10","i20","i30","ix20","ix35","ix55","Santa Fe","Sonata","Terracan","Tucson"],
	Jaguar : ["S-type","X-type","XF","XJ"],
	Jeep : ["Cherokee","Compass","Grand Cherokee","Wrangle"],
	Kia : ["Carens","Cee'd","Cerato","Optima","Rio","Sorento","Soul","Sportage","Venga"],
	"Land-Rover" : ["Defender","Discovery","Discovery Sport","Freelander","Range Rover","Range","Rover Evoque","Range Rover Sport"],
	Mazda : ["2","3","5","6","626","CX-7","Premacy","RX-8"],
	"Mercedes-Benz" : [],
	Mitsubishi: ["ASX","COLT","Eclipse","L200","Lancer","Outlander","Pajero","Pajero Pinin","Space Star"],
	Nissan : ["Almera","Juke","Micra","Pathfinder","Patrol","Primastar","Qashqai","Terrano","Tiida","X-trail"],
	Opel : ["Adam","Agila","Antara","Astra","Combo","Corsa","Frontera","Insignia","Meriva","Movano","Omega","Rekord"],
	Peugeot : ["107","108","206","207","208","3008","306","307","308","4007","406","407","5008","508","607","Bipper","Expert","Partner"],
	Porsche : ["Boxster","Cayenne","Panamera"],
	Renault : ["Clio","Espace","Fluence","Grand Scenic","Kangoo","Koleos","Laguna","Latitude","Megane","Scenic","Symbol","Trafic","Twingo"],
	Seat : ["Alhambra","Altea","Cordoba","Exeo","Ibiza","Leon","Toledo"],
	Skoda : ["Fabia","Felicia","Octavia","Rapid","Roomster","Superb","Yeti"],
	Suzuki : ["Alto","Grand Vitara", "Ignis","Jimny","Samurai","Splash","SX4","Vitara"],
	Toyota : ["Auris","Avensis","Aygo","Corolla","Land Cruiser","Prius","Tacoma","Yaris"],
	Volkswagen : ["Beetle","Bora","Caddy","Caravelle","Crafter","Eos","Fox","Golf","Jetta","Lupo","Passat","Passat CC","Phaeton","Scirocco","Tiguan","Touareg","Touran"],
	Volvo : ["C30","C70","S40","S60","S80","S90","V40","V50","V60","XC 60"]
}

function makeSubmenu(value) {
	if (value.length == 0) {
		document.getElementById("modelId").innerHTML = "<option></option>";
	} else {
		var modelOptions = "";
		for (modelCar in carModels[value]) {
			modelOptions += "<option>" + carModels[value][modelCar]
					+ "</option>";
		}
		document.getElementById("modelId").innerHTML = modelOptions;
	}
}

function resetSelection() {
	document.getElementById("marcaId").selectedIndex = 0;
	document.getElementById("modelId").selectedIndex = 0;
	document.getElementById("pretDeLa").selectedIndex = 0;
	document.getElementById("pretPanaLa").selectedIndex = 0;
}