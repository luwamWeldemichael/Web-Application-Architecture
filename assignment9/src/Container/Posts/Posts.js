import Post from "../../Component/Post/Post";

const Posts = (props) => {
    const posts = props.data.map(post => {

        return <Post
            id={post.id}
            title={post.title}
            author={post.author}
            key={post.id}
            content={post.content}
            setSelected = {() => {props.setSelected(post.id)}}
            deletePost = {() => {props.deletePost(post.id)}}
        />
    })

    return posts;
}

export default Posts;