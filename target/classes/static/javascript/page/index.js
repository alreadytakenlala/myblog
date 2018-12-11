$(function () {
    let pageNum = $(".index").val();
    let node = $(".index").nextAll().eq(pageNum - 1);
    node.addClass("active");
})