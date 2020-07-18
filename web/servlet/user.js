//고객 ID로 찾기
$(document).ready(function(){
    $( "#button" ).click(function(e) {
        e.preventDefault();

        let data = { id: $('#id').val()};

        if($("#id").val()=='') {
            alert('ID를 입력해주세요'); $('#id').focus();
            return;
        }

        $.ajax({
            type: "post",
            url: "/user",
            data: data,
            dataType: 'json',
            success: function(data) {

                html="";

                for(i in data){
                    html += '<TR>';
                    html += '<TD>'+data[i].id+'</TD>';
                    html += '<TD>'+data[i].password+'</TD>';
                    html += '<TD>'+data[i].name+'</TD>';
                    html += '<TD>'+data[i].email+'</TD>';
                    html += '<TD>'+data[i].joindate+'</TD>';
                    html += '<TD><input type="button" id="delete" value="삭제" /></TD>'
                }
                $("#tBody").empty();
                $("#tBody").append(html);
            },
            error: function(err) {
                console.log("error!");
            }
        });
    });
});

//고객 삭제
$(document).on("click","#delete",function(){

    let data = { delete : $("#tBody").children().children().eq(0).text()};

    $.ajax({
        type: "post",
        url: "/user",
        data: data,
        dataType: 'json',
        success: function(data) {
            $(this).parent().parent().remove();
            alert("삭제 완료");
        },
        error: function(err) {
            console.log("error!");
        }
    });
});

//주문 삭제
