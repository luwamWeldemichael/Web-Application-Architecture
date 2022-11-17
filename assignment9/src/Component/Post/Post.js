

const Post = (props) => {
    return (
        <div className="Content" onClick={props.setSelected}>
            <h3>Id: {props.id}</h3>
            <h3>Title: {props.title}</h3>
            <h3>Author: {props.author}</h3>
           <h3>Content: {props.content}</h3>
        </div>
    );
}

export default Post;