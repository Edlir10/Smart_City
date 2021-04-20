var urlMenu = document.getElementById('dropdown');
urlMenu.onchange = function openLinkInNewTab(event) {
  var value = event.target.value;
  if (value != "") {
    window.open(value);
  }
}