/**
 * TODO : 
 * - Ajouter les icones svg dans le projet et les linker dans ce script
 * - Styliser les intitulés de catégories (HTML, Editorial, Graphique)
 */

var popupButtons = document.querySelectorAll('.theme-details a[data-toggle="modal"]');
var modals = [];

if (popupButtons){

    // collecting all modals and store them in an array
    for (var i = 0; i < popupButtons.length; i++){
        var modal = document.querySelector(popupButtons[i].dataset.target);
        modals.push(modal);
    }
    
    // order and render the guidelines for the selected RGAA rule
    popupButtons.forEach(function(btn){
        btn.addEventListener('click', function(){
            var target = btn.dataset.target;
            var modal = document.querySelector(target);
            var guides = {
                html : {
                    categoryName: 'HTML',
                    className: 'H',
                    items: [],
                    iconUrl: '/../Images/html.svg'
                },
                edito : {
                    categoryName: 'Editorial',
                    className: 'E',
                    items: [],
                    iconUrl : '/../Images/edito.svg'
                },
                graph : {
                    categoryName: 'Graphique',
                    className: 'G',
                    items: [],
                    iconUrl : '/../Images/graph.svg'
                }
            }
    
            renderPractices(modal, guides);
        });
    })
}

/**
 * AcceDe Web Practices Pop-up
 * Creates DOM lists to render the category title
 * and the corresponding guidelines
 * 
 * DOM result :
 * ul[container] > li[category] > span[icon + category name] + ul[guideList] 
 * 
 * @param {Object} container - container in which the guide list will be
 * @param {Object} guide - object defined in var guides
 */
function createPracticesLists(container, guide){
    var category = document.createElement('li');
    var guideList = document.createElement('ul');

    category.className = guide.className;

    // append category icon + category name
    category.innerHTML = '<span><img src="'
        + guide.iconUrl
        + '" class="icon_accede" alt="" aria-hidden="true"/>'
        + guide.categoryName 
        + '</span>';
    
    
    // append all guidelines ('li' elements) to list
    for (var i = 0; i < guide.items.length; i++){
        guideList.appendChild(guide.items[i]);
    }

    category.appendChild(guideList);
    container.appendChild(category)
}

/**
 * AcceDe Web Practices Pop-up
 * Renders the guidelines list in the pop up
 * and adds class 'is-filled' to prevent multiple rendering
 * 
 * @param {Object} modal - targeted modal
 * @param {Object} guides - object containing all categories and their infos
 */
function renderPractices(modal, guides){
    var guidesContainer = modal.querySelector('.accedeweb');
    var guidelines = modal.querySelectorAll('.accedeweb li');

    // only order the guidelines if pop up has been opened yet
    if (!guidesContainer.classList.contains('is-filled')){

        // collects all guidelines and classifies them
        for (var i = 0; i < guidelines.length; i++){
            if (guidelines[i].className == 'H'){
                guides.html.items.push(guidelines[i]);
            } else if (guidelines[i].className == 'E') {
                guides.edito.items.push(guidelines[i]);
            } else if (guidelines[i].className == 'G'){
                guides.graph.items.push(guidelines[i])
            } 
        }

        // clear the main guidelines container
        guidesContainer.innerHTML = '';

        // generate guidelines lists if guidelines exist
        if (guides.html.items.length > 0) {
            createPracticesLists(guidesContainer, guides.html); 
        }

        if (guides.edito.items.length > 0){
            createPracticesLists(guidesContainer, guides.edito);
        }

        if (guides.graph.items.length > 0){
            createPracticesLists(guidesContainer, guides.graph);
        }

        // pop up has been opened
        guidesContainer.classList.add('is-filled');
    }
}
