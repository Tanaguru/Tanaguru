$(window).scroll(function() {
    var position = $(this).scrollTop();
    $('.thematique').each(function() {
        var target = $(this).offset().top;
        var id = $(this).attr('id');
        
        if (position >= target) {
            $('#navigation > ol > li').removeClass('on');
            $('#navigation > ol > li > a[href=#' + id + ']').parent().addClass('on');
        }
    });
});