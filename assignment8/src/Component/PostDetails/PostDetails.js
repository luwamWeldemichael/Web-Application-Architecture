import './PostDetails.css'
import axios from 'axios'
import { useEffect, useState } from 'react'
import Comment from '../Comment/Comment'

const PostDetails = (props) => {
  const edit = () => { }

  const [postCommentDetails, setPostCommentDetails] = useState([])

  useEffect(() => {
    axios.get('http://localhost:8080/api/posts/' + props.id + '/comments')
      .then(response => {
        setPostCommentDetails(response.data)
      })
      .catch(error => { console.log(error.message) })
  }, [props.id])

  return (
    <div className="PostDetails">
      <h2><u>{props.title}</u></h2>
      <h3>{props.author}</h3>
      <h3>{props.comments}</h3>
      <div className='text'>
        <p>{props.content}</p>
      </div>
      <br />
      <br />

      <button onClick={edit}>edit</button>
      <button onClick={() => { props.deletePost(props.id) }}>delete</button>
      <div style={{ textAlign: "left" }} className="PostDetails">
        <h2>Comments</h2>
        {postCommentDetails != null ? postCommentDetails.map(comment => {
          return <Comment comments={comment.name} key= {comment.id}/>
        }) : null}
      </div>

    </div>
  );
}
export default PostDetails;