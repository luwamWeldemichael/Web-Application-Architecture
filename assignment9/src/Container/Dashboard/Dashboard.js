import { useContext, useEffect, useState } from "react";
import PostDetails from "../../Component/PostDetails/PostDetails";
import Posts from "../Posts/Posts";
import axios from "axios";
import AddPost from "../../Component/AddPost/AddPost";
import { Context } from "../../Store/Context";
import AddPostWithRef from "../../Component/AddPost/AddPostWithRef";

const Dashbord = () => {

    const [posts, setPosts] = useState([
        { id: 1, title: 'Happiness', author: 'John', content: 'hi' },
        { id: 2, title: 'MIU', author: 'Dean', content: 'hi' },
        { id: 3, title: 'Enjoy Life', author: 'Jasmine', content: 'hi' },
    ]);

    const [postAPI, setPostAPI] = useState('http://localhost:8080/api/posts/')

    const [selected, setSelected] = useState(0);

    const [flag, setFlag] = useState(true);

    const [title, setTitle] = useState("");

    const fetchData = () => {
        axios.get(postAPI)
            .then(response => {
                setPosts(response.data)
            })
            .catch(error => {
                console.log(error.message)
            })
    }

    useEffect(() => { fetchData() }, [flag])

    const updateFlag = () => {
        setFlag(!flag);
    }

    const setSelectedHandler = (id) => {
        setSelected(id);
        console.log(id)
    }

    const changeTitle = () => {
        posts[0].title = title;
        setPosts([...posts])
    }

    const deleteHandler = (id) => {
        axios.delete(postAPI + 'delete/' + id)
            .then(response => {
                fetchData(); console.log(response)
            })
            .catch(error => {
                console.log(error.message)
            })
    }


    return (
        <Context.Provider value={{ id: selected, postAPI: postAPI }}>

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
                        title={{ ...posts[selected - 1] }.title}
                        author={{ ...posts[selected - 1] }.author}
                        content={{ ...posts[selected - 1] }.content}
                        key = {selected}
                        deletePost={deleteHandler}
                    />


                </div>
                <div>
                    <AddPost
                        id={posts.id}
                        title={posts.title}
                        author={posts.author}
                        content={posts.content}
                        updateFlag={updateFlag}

                    />
                </div>

                <div>
                    <AddPostWithRef updateFlag={updateFlag}/>
                </div>
            </div>
        </Context.Provider>
    );
}

export default Dashbord;