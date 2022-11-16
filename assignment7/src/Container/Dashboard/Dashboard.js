import { useState } from "react";
import PostDetails from "../../Component/PostDetails/PostDetails";
import Posts from "../../Component/Posts/Posts";

const Dashbord = () => {

    const [posts, setPosts] = useState([
        { id: 111, title: 'Happiness', author: 'John', content: ' This is the first content in the post…' },
        { id: 112, title: 'MIU', author: 'Dean', content: ' This is the second content in the post…' },
        { id: 113, title: 'Enjoy Life', author: 'Jasmine', content: ' This is the third content in the post…' },
    ]);

    const [selected, setSelected] = useState(0);

    const post = posts.filter(post => post.id === selected)

    const setSelectedHandler = (id) => {
        setSelected(id);
        console.log(id);
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
                />
            </div>

        </div>
    );
}

export default Dashbord;