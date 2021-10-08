var btnMinPlus = function(){
    $(".js-btn-minus").on("click",function(){
        // e.preventDefault();
        if($(this).closest('.cant-container').find('.form-control').val()!=0){
            $(this).closest('.cant-container').find('.form-control').val(parseInt($(this).closest('.cant-container').find('.form-control').val()) - 1);
        }else{
            $(this).closest('.cant-container').find('.form-control').val(parseInt(0));
        }
    })
    $(".js-btn-plus").on("click",function(){
        // e.preventDefault();
        $(this).closest('.cant-container').find('.form-control').val(parseInt($(this).closest('.cant-container').find('.form-control').val())+1);
    })
}
btnMinPlus();