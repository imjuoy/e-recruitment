function loadXMLDoc_search() {
	var xmlhttp;
	var v = document.search.country.value;
	var urls = "getemp_details.jsp?ok=" + v;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		removeall();
		if (xmlhttp.readyState == 4) {
			z = 0;
			/*var roott = xmlhttp.responseXML.documentElement;
			var ress = roott.getElementsByTagName("empname")[z].childNodes[0].nodeValue;
			System.out.println(ress);
			while (ress != null)
			{
				document.getElementById("a").innerHTML = roott.getElementsByTagName("empno")[z].childNodes[0].nodeValue;
				document.getElementById("b").innerHTML = roott.getElementsByTagName("location")[z].childNodes[0].nodeValue;
				z++;
				document.getElementById("c").innerHTML = roott.getElementsByTagName("empname")[z].childNodes[0].nodeValue;
			}*/
		}
		
		}
	xmlhttp.open("GET", urls, true);
	xmlhttp.send();
     }