

const AddPost = (props) => {
    return (
        <div>
            <h1>Add a Post</h1>

            <label>Title</label>
            <input type="text"
                label={'title'}
                name={'title'}
                onChange={props.onChange}
                value={props.title}
            />

            <label>Author</label>
            <input type="text"
                label={'author'}
                name={'author'}
                onChange={props.onChange}
                value={props.price}
            />

             <label>Content</label>
            <input type="text"
                label={'content'}
                name={'content'}
                onChange={props.onChange}
                value={props.title}
            />

            <button onClick={props.addButtonClicked}>Add Post </button>
        </div>
    )
}

export default AddPost;