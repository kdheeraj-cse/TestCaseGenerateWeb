function hideExcept(value) {
	var int;
	var mainDivs = ["dashboarddiv","createtestdiv","savediv","historydiv","editprofilediv","searchdiv"];
	for (int = 0; int < mainDivs.length; int++) {
		if (mainDivs[int]==value) {
			continue;
		}
			document.getElementById(mainDivs[int]).style.display="none";
	}
}

function showContextForm (value) {
	
	switch (value) {
	case "Dashboard":
		document.getElementById("dashboarddiv").style.display="block";
		hideExcept("dashboarddiv");
		break;
	case "Create_Test":
		document.getElementById("createtestdiv").style.display="block";
		hideExcept("createtestdiv");
		break;
	case "Saved_Files":
		document.getElementById("savediv").style.display="block";
		hideExcept("savediv");
		break;
	case "History":
		document.getElementById("historydiv").style.display="block";
		hideExcept("historydiv");
		break;
	case "Edit_Profile":
		document.getElementById("editprofilediv").style.display="block";
		hideExcept("editprofilediv");
		break;
	case "Search":
		document.getElementById("searchdiv").style.display="block";
		hideExcept("searchdiv");
		break;
	}
}


function showJsonUploadForm() {
	$("#jsonUpload").modal('show');
}

function showExcelUploadForm() {
	$("#excelUpload").modal('show');
}

function showJsonSelect() {
	$("#jsonSelect").modal('show');
}

function showExcelSelect() {
	$("#excelSelect").modal('show');
}

function startUpload() {
	console.log("inside upload");
	$('input[type="file"]').ajaxfileupload({
	       'action': 'doupload',            
	   'onComplete': function(response) {         
	         $('#upload').hide();
	         alert("File SAVED!!");
	       },
	       'onStart': function() {
	         $('#upload').show(); 
	       }
	  });
}