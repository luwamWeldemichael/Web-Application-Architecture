import { useDeferredValue, useEffect, useState } from "react";
import PostDetails from "../../Component/PostDetails/PostDetails";
import Posts from "../../Component/Posts/Posts";
import axios from "axios";
import AddPost from "../../Component/AddPost/AddPost";

const Dashbord = () => {

    const [posts, setPosts] = useState([
        { id: 1, title: 'Happiness', author: 'John' },
        { id: 2, title: 'MIU', author: 'Dean' },
        { id: 3, title: 'Enjoy Life', author: 'Jasmine' },
    ]);

    const fetchData = () => {
        axios.get('http://localhost:8080/api/posts')
            .then(response => {
                setPosts(response.data)
            })
            .catch(error => {
                console.log(error.message)
            })
    }

    useEffect(() => { fetchData() }, [])

    const deleteHandler = (id) => {
        axios.delete('http://localhost:8080/api/posts/delete/' + id )
        console.log("delete method called")
            .then(response => { fetchData() })
            .catch(error => {
                console.log(error.message)
            })
    }

    const [selected, setSelected] = useState(0);
    
    const post = posts.filter(p => p.id==selected);


    const setSelectedHandler = (id) => {
        setSelected(id);
        console.log(id)
    }

    const [title, setTitle] = useState("");

    const changeTitle = () => {
        posts[0].title = title;
        setPosts([...posts])
    }


    return (
        <div>
            <div className="Post">
                <Posts data={posts} setSelected={setSelectedHandler} />
            </div>

            <div>
                <input type="text" id="text" title="title" onChange={(title) => setTitle(title.target.value)} /><br />
                <button className="button" onClick={changeTitle}>Change Title</button>
            </div>

            <div>
                <PostDetails
                    id={selected}
                    title={post[0].title}
                    author={post[0].author}
                    content={post[0].content}
                    deletePost={deleteHandler}
                />
            </div>
            <div>
                <AddPost
                    title={posts.title}
                    author={posts.author}
                    content={posts.content}
                />
            </div>
        </div>
    );
}

export default Dashbord;