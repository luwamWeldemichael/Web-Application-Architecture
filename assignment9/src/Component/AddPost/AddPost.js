import './AddPost.css'

const AddPost = (props) => {
    return (
        <div className="AddPost">
            <h1>Add Post</h1>
            <form>
                <label>Id: </label>
                <input type="text"
                    label={'id'}
                    name={'id'}
                    onChange={props.onChange}
                    value={props.title}
                />
                <label>Title: </label>
                <input type="text"
                    label={'title'}
                    name={'title'}
                    onChange={props.onChange}
                    value={props.title}
                />

                <label>Author: </label>
                <input type="text"
                    label={'author'}
                    name={'author'}
                    onChange={props.onChange}
                    value={props.price}
                />

                <label>Content: </label>
                <input type="text"
                    label={'content'}
                    name={'content'}
                    onChange={props.onChange}
                    value={props.title}
                />

                <button onClick={() => { props.addPost() }}>Add Post </button>

            </form>

        </div>
    )
}

export default AddPost;