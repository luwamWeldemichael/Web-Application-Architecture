import Post from "../Post/Post";

const Posts = (props) => {
    const posts = props.data.map(post => {

        return <Post
            id={post.id}
            title={post.title}
            author={post.author}
            key={post.id}
            setSelected={() => { props.setSelected(post.id) }}
        />
    })

    return posts;
}

export default Posts;