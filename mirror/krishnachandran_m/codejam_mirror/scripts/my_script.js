function compare(){
    var im1=$('#image1').val();
    var im2=$('#image2').val();
    if(im1 !='' && im2!=''){
        $('#compare').fadeOut($('#processing').fadeIn());
        $.post("imagecomp.php", $("#imname").serialize(),
            function(data){
                $('#result').attr("innerHTML",'<br/>'+data);
                $('#result').focus();
                $('#processing').fadeOut($('#compare').fadeIn());
                count=0;
            });
    }
}
function change(e){
    if(e.id=='image1'){
        $('#image1prev').attr("src",$('#image1').val());
    }
    else if(e.id=='image2'){
        $('#image2prev').attr("src",$('#image2').val());
    }
}