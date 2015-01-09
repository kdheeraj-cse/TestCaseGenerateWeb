var ajaxRequest;  // The variable that makes Ajax possible!
function ajaxFunction(){
 try{
   // Opera 8.0+, Firefox, Safari
   ajaxRequest = new XMLHttpRequest();
 }catch (e){
   // Internet Explorer Browsers
   try{
      ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
   }catch (e) {
      try{
         ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
         // Something went wrong
         alert("Your browser broke!");
         return false;
      }
   }
 }
}


function uploadStart(path)
{
	//alert(path);
	document["uploadProg"].src = "Bootstrap/Images/upload_progress.gif";
	ajaxFunction();
	   // Here processRequest() is the callback function.
	   ajaxRequest.onreadystatechange = processRequest;
	   if (!target) target = document.getElementById("userid");
	   var url = "upload?id=" + escape(target.value);
	   ajaxRequest.open("GET", url, true);
	   ajaxRequest.send(null);
	
}

function showCreateTest() {
	document.getElementById("createTest").style.display ='block';
	
}

function showHistory() {
	document.getElementById("createTest").style.display ='none';
}

function logout(){
	
	}
