import './PostDetails.css'
import axios from 'axios'
import { useContext, useEffect, useState } from 'react'
import Comment from '../Comment/Comment'
import { Context } from '../../Store/Context'

const PostDetails = (props) => {
  const edit = () => { }

  const [postCommentDetails, setPostCommentDetails] = useState([])

  const selectedId = useContext(Context).id;

  const postAPI = useContext(Context).postAPI;

  useEffect(() => {
    axios.get(postAPI + selectedId + '/comments/')
      .then(response => {
        setPostCommentDetails(response.data)
      })
      .catch(error => { console.log(error.message) })
  }, [selectedId])

  console.log(postCommentDetails);


  return (
    <div className="PostDetails">
      <h2><u>{props.title}</u></h2>
      <h3>{props.author}</h3>
      <div className='text'>
        <p>{props.content}</p>
      </div>
      <br />
      <br />

      <button onClick={edit}>edit</button>
      <button onClick={() => { props.deletePost(selectedId) }}>delete</button>

    
      <div style={{ textAlign: "left" }} className="PostDetails">
      <h2>Comments</h2>
        {postCommentDetails != null ? postCommentDetails.map(comment => {
          return <Comment comments={comment.name} />
        }) : null}
      </div>

    </div>
  );
}
export default PostDetails;