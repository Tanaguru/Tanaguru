(function(){
    var ea_inputs = document.querySelectorAll('.option-console-eaccessible input[id*="lvl"]');
    var body = document.querySelector('body');
    var selected = document.querySelector('input[id*="lvl"]:checked');
    var btn_expand = document.querySelector('#expand-all');
    var btn_collapse = document.querySelector('#collapse-all');
    var btn_reset = document.querySelector('.option-console-eaccessible .update-action')
    
    ea_inputs = Array.prototype.slice.call(ea_inputs);

    btn_reset.addEventListener('click', function(e){
        e.preventDefault();

        if (selected){
            selected.checked = false;
        }
        body.className = '';
        btn_collapse.click();
    })

    ea_inputs.forEach(function(input) {
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

})();