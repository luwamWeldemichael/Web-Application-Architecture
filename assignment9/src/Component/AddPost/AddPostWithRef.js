import React, { useContext, useEffect, useRef } from "react";
import { Context } from "../../Store/Context";
import axios from "axios";

const AddPostWithRef = (props) => {

    const addPostForm = useRef();

    const postAPI = useContext(Context).postAPI;

    const AddPost = () => {

        const form = addPostForm.current;

        const data = {
            id: form.id.value,
            title: form.title.value,
            author: form.author.value,
            content: form.content.value
        };

        axios.post(postAPI, data)
            .then(data => {
                console.log('Success', data);
                props.updateFlag();
            })
            .catch(error => {
                console.error('Error:', error);
            })

    }

    return (
        <div className="AddPost">
            <h2>Add Post With Ref</h2>
            <form ref={addPostForm}>
                <label>Id: </label>
                <input type="text"
                    label='myid'
                    name='id'
                />
                <label>Title: </label>
                <input type="text"
                    label='title'
                    name='title'
                />

                <label>Author: </label>
                <input type="text"
                    label='author'
                    name={'author'}
                />

                <label>Content: </label>
                <input type="text"
                    label='content'
                    name='content'
                />
            </form>
            <button onClick={AddPost}>Add Post </button>
        </div>

    );
}

export default AddPostWithRef;
