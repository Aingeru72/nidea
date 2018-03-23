/* JS NIDEA */

// Variables del DOM
var colorPicker = document.querySelector("#muestra-color");
var chkColor = document.querySelector("#chkColor");

chkColor.addEventListener('change', function() {
	if ( chkColor.checked ) {
		colorPicker.style.display = "flex";
	} else {
		colorPicker.style.display = "none";
	}
});
