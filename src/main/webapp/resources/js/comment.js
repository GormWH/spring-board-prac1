
const commentService = (function () {

  const getList = async function({bno, page, size}, callback) {

    const parameters = {page:page||1, size:size||10} // listDTO
    const res = await axios.get(`/comment/list/${bno}`, {params: parameters});
    console.log(res.data);
    callback(res.data); // commentList in JSON format
  }

  const addComment = async function (comment, callback) {
    const res = await axios.post(`/comment/register`, comment);

    const commentCount = parseInt(res.data.result);
    const bno = comment.bno;
    const page = Math.ceil(commentCount / size);

    callback({bno, page, size})
  }
  return {getList, addComment};
}) ();