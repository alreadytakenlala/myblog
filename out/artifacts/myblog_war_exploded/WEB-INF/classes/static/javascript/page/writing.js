function publish() {
    let id = $("#id").val();
    let title = $("#title").val();
    let description = $("#description").val();
    // let content = $("#content").text();
    let content = document.querySelector("#content").innerHTML;
    let radioVal = $("input[name='rd']:checked").next().text();

    if (radioVal == "")
    {
        alert("请选择博客所属话题");
        return;
    }

    $.ajax({
        url:"/writing/publish",
        type:"post",
        dataType:"json",
        data:{"id":id, "title":title, "description":description, "content":content, "topicName":radioVal},
        success:function(result)
        {
            alert(result.message);
            location.reload();
        },
        error:function (result) {
            alert(result.message);
        }
    })
}

function getArticle(id)
{
    $.ajax({
        url:"/writing/getArticle",
        type:"post",
        dataType:"json",
        data:{"id":id},
        success:function(result)
        {
            $("#id").val(result.id);
            $("#title").val(result.title);
            $("#description").val(result.description);
            $("#content").append(result.content);

            alert(result.title);
        },
        error:function (result) {
            alert(result.message);
        }
    })
}

function deleteArticle(id) {
    if (confirm("您要删除这篇文章？"))
    {
        $.ajax({
            url:"/writing/deleteArticle",
            type:"post",
            dataType:"json",
            data:{"id":id},
            success:function(result)
            {
                alert(result.message);
                location.reload();
            },
            error:function (result) {
                alert(result.message);
            }
        })
    }
}