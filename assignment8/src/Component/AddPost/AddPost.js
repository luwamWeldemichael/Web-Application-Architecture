import { useState } from 'react'
import './AddPost.css'
import axios from 'axios'


const AddPost = (props) => {

    const [postToBeAdded, setPostToBeAdded] = useState({
        title: '',
        content: '',
        author: '',
    })

    const addPost = (event) => {
        event.preventDefault();
        axios.post('http://localhost:8080/api/posts', postToBeAdded)
            .then(response => {
                props.updateFlag();
                console.log('successfully saved');
            })
            .catch(error => { console.log(error.message) })
    }

    return (
        <div className="AddPost">
            <h1>Add Post</h1>
            <form>
                <label>Id: </label>
                <input type="text"
                    label={'id'}
                    name={'id'}
                    value={props.id} onChange={(event) => setPostToBeAdded({ ...postToBeAdded, id: event.target.value })}
                />
                <label>Title: </label>
                <input type="text"
                    label={'title'}
                    name={'title'}
                    value={props.title} onChange={(event) => setPostToBeAdded({ ...postToBeAdded, title: event.target.value })}
                />

                <label>Author: </label>
                <input type="text"
                    label={'author'}
                    name={'author'}
                    value={props.author} onChange={(event) => setPostToBeAdded({ ...postToBeAdded, author: event.target.value })}
                />

                <label>Content: </label>
                <input type="text"
                    label={'content'}
                    name={'content'}
                    value={props.content} onChange={(event) => setPostToBeAdded({ ...postToBeAdded, content: event.target.value })}
                />

                <button onClick={addPost}>Add Post </button>

            </form>

        </div>
    )
}

export default AddPost;