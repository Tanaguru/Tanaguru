(function(){
    var ea_inputs = document.querySelectorAll('.option-console-eaccessible input[id*="lvl"]');
    var body = document.querySelector('body');
    var selected = document.querySelector('input[id*="lvl"]:checked');
    var btn_expand = document.querySelector('#expand-all');
    var btn_collapse = document.querySelector('#collapse-all');
    var btn_reset = document.querySelector('.option-console-eaccessible .update-action');
    var audit_level = document.querySelector('#audit-level .synthesis-meta-value').textContent;
    
    ea_inputs = Array.prototype.slice.call(ea_inputs);
    
    window.addEventListener('resize', function(){
        if (window.matchMedia("(min-width: 1680px)").matches) {
            /* Make sticky options console */
            $('.option-console-eaccessible').stick_in_parent({parent: '#tgm-result-page', offset_top: 370});
            $('.option-console-standard').stick_in_parent({parent: '#tgm-result-page', offset_top: 20});
        } else {
            /* Reset elements to initial position */
            $('.option-console-eaccessible').trigger("sticky_kit:detach");
            $('.option-console-standard').trigger("sticky_kit:detach");
        }
    })

    btn_reset.addEventListener('click', function(e){
        e.preventDefault();

        if (selected){
            selected.checked = false;
        }
        body.className = '';
        btn_collapse.click();
    })

    ea_inputs.forEach(function(input) {
        hideInputs(input, audit_level);

        input.addEventListener('change', function(){
            if (selected){
                !selected.checked; // uncheck the previously selected
            }

            this.checked; // check the currently selected
            selected = this; // selected is now the currently checked

            btn_expand.click();

            switch(this.id) {
                case 'lvl1':
                    body.className = 'show-eaccessible-lvl1';
                    break;
                case 'lvl2':
                    body.className = 'show-eaccessible-lvl2';
                    break;
                case 'lvl3':
                    body.className = 'show-eaccessible-lvl3';
                    break;
                case 'lvl5':
                    body.className = 'show-eaccessible-lvl5';
                    break;
            }
        })
    })

    function hideInputs(item, audit_lvl){
        if (audit_lvl == 'A' && (item.id == 'lvl3' || item.id == 'lvl5')){
            item.parentNode.style.display = 'none';
        } else if (audit_lvl == 'AA' && item.id == 'lvl5'){
            item.parentNode.style.display = 'none';
        }
    }

})();
