var pathListKQXS = '/data/kqxs.xml';

function getDanhSachMien() {
    var xmlDoc = new ActiveXObject("MSXML.DOMDocument");
    xmlDoc.async = "false";
    xmlDoc.load(pathListKQXS);
    var root = xmlDoc.documentElement;
    
    var miens;
    var i = 1;
    for (x in root) {
        miens[i++] = x;
    }
    



}