/**
* Trigger print on click
*/

(function(){
  var printBtn = document.querySelector('#print-results-button');
  
  printBtn.addEventListener('click', function(){
    window.print();
  })
})();
