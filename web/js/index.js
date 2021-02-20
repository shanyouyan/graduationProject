$(function () {

   /*广告的关闭*/

    $(".advertise a").click(function () {
        $(this).parents().find(".advertise").hide();
    });

    /*问答页关注和回答按钮的显示*/
    $(".cont-item").hover(function(){
        $(".cont-focus").css("display","block");
        $(this).siblings().find(".cont-focus").css("display","none");
    },function(){
        $(".cont-focus").css("display","none");
    });
});
