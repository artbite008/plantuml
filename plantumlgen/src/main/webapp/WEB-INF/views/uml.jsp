<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>uml</title>
    <link rel="stylesheet" rel="stylesheet"  href="css/style.css">

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/ace.js"></script>
    <script type="text/javascript">
        var edit = function () {
            $('#left').removeClass('hidden');
            $('#right').removeClass('whole');
            $('#right').addClass('split');
            $('#edit').addClass('hidden');
        }
        var done = function () {
            $('#left').addClass('hidden');
            $('#right').removeClass('split');
            $('#right').addClass('whole');
            $('#edit').removeClass('hidden');
        }
        var refresh = function () {
            var umlId = $('#umlid').val();
            var readUrl = $('#readUrl').val();

            var editor = ace.edit("editor");
            var umlText = editor.getValue().trim();

            if(umlId && umlText){
                $('#refreshbutton').attr('disabled','disabled');
                $('#donehbutton').attr('disabled','disabled');

                $.ajax({
                    url: 'uml/'+umlId,
                    type: 'POST',
                    data: umlText,
                    contentType: 'application/plain;charset=uft-8',
                    success: function (result, textStatus, jqXHR) {
                        if(result==='ok'){
                            $('#umlchart').attr("src",readUrl+'/'+umlId+'.png?'+(Math.random()*1000000));
                        }else{
                            alert('Process Failure: ' + result);
                        }
                        $('#refreshbutton').removeAttr('disabled');
                        $('#donehbutton').removeAttr('disabled');
                    },
                    error: function (jqXHR,textStatus,errorThrown) {
                        alert('Error: '+url+' ' + jqXHR + '/' + textStatus + '/' + errorThrown);
                        $('#refreshbutton').removeAttr('disabled');
                        $('#donehbutton').removeAttr('disabled');
                    }
                });

            }
        }
    </script>


</head>
<body>
<input type="hidden" id="umlid" value="${umlid}"/>
<input type="hidden" id="readUrl" value="${readUrl}"/>
<div class="split left hidden" id="left">
    <button class="actionbutton" id="donehbutton" style="width:100px;" onclick="done(); return false;">Done</button>
    <button class="actionbutton" id="refreshbutton" style="width:100px;" onclick="refresh(); return false;">Refresh</button>
    <div id="editor">${umltext}</div>
</div>

<div class="whole right" id="right">
    <div id="edit">
        <a href="#" onclick="edit()" >Edit</a>
    </div>
    <div id="image">
        <img src="${readUrl}/${umlid}.png" id="umlchart">
    </div>
</div>
</body>
<script>
    ace.edit("editor");
    $('#umlchart').attr("src",'${readUrl}/${umlid}.png?'+(Math.random()*1000000));
</script>
</body>
</html>
