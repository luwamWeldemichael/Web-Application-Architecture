import './PostDetails.css'

const PostDetails = (props) => {
    const edit = () =>{}
  
    // const deleteDetails = () =>{}

    return (
        <div className="PostDetails">
            <h2>{props.title}</h2>
            <h3>{props.author}</h3>
          <div className='text'> 
            <h4>{props.content}</h4>
          </div>
            <br/> 
            <br/>
            
            <button onClick={edit}>edit</button>
            <button onClick={props.deletePost}>delete</button>
          
        </div>
    );
}
export default PostDetails;