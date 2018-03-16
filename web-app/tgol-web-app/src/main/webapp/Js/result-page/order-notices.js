/**
 * 
 * TODO : 
 * - Linker le script aux templates result-page.jsp
 * - Ajouter les icones svg dans le projet et les linker dans ce script
 * - Ajouter les styles suivants :  
 * .accedeweb > li { 
 *     list-style: none;
 *     margin-bottom: 1rem;
 * }
 * 
 * .accedeweb > li > span,
 * .accedeweb > li > ul {
 *     display: inline-block;
 *     vertical-align: top;
 * }
 * 
 * - Styliser les intitulés de catégories (HTML, Editorial, Graphique)
 * - Optimiser le JS
 * 
 */

const buttons = document.querySelectorAll('.theme-details a[data-toggle="modal"]');
let modals = [];

for (let i = 0; i < buttons.length; i++){
    let modal = document.querySelector(buttons[i].dataset.target);
    modals.push(modal);
}

buttons.forEach(function(btn){
    btn.addEventListener('click', function(){
        const target = btn.dataset.target;
        const modal = document.querySelector(target);
        let guidesContainer = modal.querySelector('.accedeweb');
        let guidelines = modal.querySelectorAll('.accedeweb li');
        let guidesHtml = {
            items: [],
            iconUrl: ''
        };
        let guidesEdit = {
            items: [],
            iconUrl: 'icons/notice_edito.svg'
        } 
        let guidesGraph = {
            items: [],
            iconUrl: 'icons/notice_graphique.svg'
        }


        if (!guidesContainer.classList.contains('is-filled')) {
            // on trie dans des tableaux distincts les règles AcceDe Web
            for (var i = 0; i < guidelines.length; i++){
                if (guidelines[i].className == 'H'){
                    guidesHtml.items.push(guidelines[i]);
                } else if (guidelines[i].className == 'E') {
                    guidesEdit.items.push(guidelines[i]);
                } else if (guidelines[i].className == 'G'){
                    guidesGraph.items.push(guidelines[i])
                } 
            }
            // on vide le container des notices AcceDe Web
            guidesContainer.innerHTML = '';

            /**
             * Structure de présentation des notices AcceDe Web
             * <ul class="accedeweb">
             *  <li class="H">
             *    <ul>
             *      <li>Règles relatives au code HTML</li>
             *      ...
             *      </li>
             *    </ul>
             *  </li>
             *  <li class="E">
             *  ...
             *  </li>
             * </ul>
             * 
             * La partie ci-dessous a cruellement besoin d'optimisation
             */

            const catH = document.createElement('li');
            const catE = document.createElement('li');
            const catG = document.createElement('li');
            catH.className = 'H';
            catE.className = 'E';
            catG.className = 'G';

            if (guidesHtml.items.length > 0) {
                let guideList = document.createElement('ul');

                catH.innerHTML = `
                    <span class=">
                        <img src="${guidesHtml.iconUrl}" alt="" aria-hidden="true"/>
                        HTML
                    </span>
                    `;

                for (let i = 0; i < guidesHtml.items.length; i++){
                    guideList.appendChild(guidesHtml.items[i]);
                }

                catH.appendChild(guideList);
                guidesContainer.appendChild(catH);    
            }

            if (guidesEdit.items.length > 0){
                let guideList = document.createElement('ul');
                
                catE.innerHTML = `
                    <span>
                        <img src="${guidesEdit.iconUrl}" alt="" aria-hidden="true"/>
                        Editorial
                    </span>
                    `;

                for (let i = 0; i < guidesEdit.items.length; i++){
                    guideList.appendChild(guidesEdit.items[i]);
                }

                catE.appendChild(guideList);
                guidesContainer.appendChild(catE);
            }

            if (guidesGraph.items.length > 0){
                let guideList = document.createElement('ul');

                catG.innerHTML = `
                    <span>
                        <img src="${guidesGraph.iconUrl}" alt="" aria-hidden="true"/>
                        Graphique
                    </span>
                    `;

                for (var i = 0; i < guidesGraph.items.length; i++){
                    guideList.appendChild(guidesGraph.items[i]);
                }

                catG.appendChild(guideList);
                guidesContainer.appendChild(catG);
            }

            if (!guidesContainer.classList.contains('is-filled')){
                guidesContainer.classList.add('is-filled');
            }
        }

    })
})


