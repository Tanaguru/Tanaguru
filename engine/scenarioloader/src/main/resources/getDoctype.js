function getDoctype(){
    var result = "";
    if(document.doctype != null) {
        result += '<!DOCTYPE ' + document.doctype.name;
        if(document.doctype.publicId){
            result += ' PUBLIC \"' + document.doctype.publicId + '\"';
        }
        if(document.doctype.systemId){
            result += ' ' + document.doctype.publicId;
        }
        result += '>';
    }
    return result;
}

return getDoctype();
