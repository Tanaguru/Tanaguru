function reorderResultsTable(){
    var resultsTable = document.querySelector('#result-by-theme'),
    theadRow = document.querySelector('#result-by-theme thead tr'),
    tbody = document.querySelector('#result-by-theme tbody'),
    auditCategories = document.querySelectorAll('#result-by-theme thead th'),
    resultsCategories = document.querySelectorAll('#result-by-theme tbody th'),
    results = {};

    function collectResults(){
        auditCategories.forEach(function(item){
            var catName = item.id;
            results[catName] = resultsTable.querySelectorAll('tbody td[headers$="' + catName + '"]')
        })
    }

    if (resultsTable){
        // collects table data before flushing it
        collectResults();

        // flush table data
        theadRow.innerHTML = '';
        tbody.innerHTML = '';

        // empty table cell
        theadRow.appendChild(document.createElement('td'));

        // replace column titles
        resultsCategories.forEach(function(item){
            theadRow.appendChild(item)
        })

        auditCategories.forEach(function(item){

            var tr = document.createElement('tr');
            var catName = item.id;

            // replace row title with RGAA category
            tr.appendChild(item);
            
            for(var i = 0; i < results[catName].length; i++){
                tr.appendChild(results[catName][i]);
                
                if (i%3 == 0){
                    tbody.appendChild(tr);
                }
            }
        })
    }
}

document.addEventListener("DOMContentLoaded", function() {
    reorderResultsTable();
});