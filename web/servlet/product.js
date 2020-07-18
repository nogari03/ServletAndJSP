//고객 ID로 찾기
$(document).ready(function(){
    $( "#submit" ).click(function(e) {
        e.preventDefault();

        let data = { productId: $('#productId').val(), companyId: $('#companyId').val()};

        if($("#productId").val()=='' && $("#companyId").val()=="") {
            alert('제품번호 혹은 공급업체 번호를 입력해주세요.'); $('#productId').focus();
            return;
        }

        $.ajax({
            type: "post",
            url: "/product",
            data: data,
            dataType: 'json',
            success: function(data) {

                html="";

                for(i in data){
                    html += '<TR>';
                    html += '<TD>'+data[i].prodId+'</TD>';
                    html += '<TD>'+data[i].prodName+'</TD>';
                    html += '<TD>'+data[i].price+'</TD>';
                    html += '<TD>'+data[i].desc+'</TD>';
                    html += '<TD>'+data[i].vendId+'</TD>';
                    html += '<TD><button id="delete">삭제</button></TD>'
                }
                $("#tBody").empty();
                $("#tBody").append(html);
            },
            error: function(err) {
                console.log("error!");
            }
        });
    });
    //추가하기
    $( "#modal_btn" ).click(function() {
        $('div.modal').modal("show");
    });
});
//고객 삭제
$(document).on("click","#delete",function(){

    let data = { delete : $("#tBody").children().children().eq(0).text()};

    $.ajax({
        type: "post",
        url: "/customer",
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
