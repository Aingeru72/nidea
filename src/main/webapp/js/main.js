/* JS NIDEA */

// Variables del DOM
var colorPicker = document.querySelector("#color-picker");
var chkColor = document.querySelector("#chkColor");

chkColor.addEventListener('change', function() {
	if ( chkColor.checked ) {
		colorPicker.style.display = "block";
	} else {
		colorPicker.style.display = "none";
	}
});
