$(window).scroll(function() {
    var position = $(this).scrollTop();
    $('.thematique').each(function() {
        var target = $(this).offset().top;
        var id = $(this).attr('id');
        
        if (position >= target) {
            $('#navigation > ul > li').removeClass('active');
            $('#navigation > ul > li > a[href=#' + id + ']').parent().addClass('active');
        }
    });
});