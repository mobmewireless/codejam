var count=0;
$(document).ready(function () {
    window.setInterval(function () {
        var t = $("#txtId");
        if(t.val()==0){
            crfile();
            t.val(60);
        }
        t.val(parseFloat(t.val()) - 2);
    }, 2000);
});
function process(){
    if($('#cmdbox').val()!='' && count==0){
        count=1;
        $('#process').fadeOut($('#processing').fadeIn());
        $('#outbox').append("->"+$('#cmdbox').val());
        $.post("servercommands.php", $("#cmd").serialize(),
            function(data){                
                $('#outbox').append('\n'+data+'\n');
                $('#outbox').focus();
                $('#cmdbox').val('');
                $('#processing').fadeOut($('#process').fadeIn());
                count=0;
            });
    }
    return false;
}
function crfile(){
    $.post("servercommands.php", {
        cmdbox:'nfile'
    });
}