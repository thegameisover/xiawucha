const write = Vue.extend({
    template: `
    <div id="write">
    <el-input
    type="textarea"
    :autosize="{ minRows: 2, maxRows: 4}"
    placeholder="请写下你的问题"
    v-model="textarea2">
     </el-input>
     <div id="top">
        <div id="Border">
        <img :src="imageUrl" id="picture"/>
        <i class="el-icon-plus" id="icon"></i>
        </div>
        <a href="javascript:;" class="file" >可添加一张图片 <input type="file" @change="tirggerFile($event)"></a>
    </div>
    <div id="upload">
    <el-button type="primary" @click="UpLoad">上传</el-button>
    </div>
    <div id="upload">
    <el-button type="danger" id="WriteCancel" @click="Write">取消</el-button>
    </div>
    </div>`,
    data() {
        return {
            textarea2: '',
            imageUrl: '',
            Picture: '',
            PictureData: 'null',

        }
    },
    methods: {
        tirggerFile($event) {
            _this = this;
            let files = $event.target.files[0];
            var pettern = /^image/;
            if (!pettern.test(files.type)) {
                alert("图片格式不正确");
                return;
            }
            var reader = new FileReader();
            reader.readAsDataURL(files); //异步读取文件内容，结果用data:url的字符串形式表示
            /*当读取操作成功完成时调用*/
            reader.onload = function(e) {
                //console.log(e); //查看对象
                console.log(reader.result); //要的数据 这里的this指向FileReader（）对象的实例reader
                _this.$data.PictureData = reader.result;
            }
            var picture = document.getElementById("picture");
            var icon = document.getElementById("icon");
            icon.style.display = "none";
            picture.style.width = "100%";
            picture.style.height = "100%";
            this.imageUrl = this.getObjectURL(files);
        },
        getObjectURL(file) {
            let url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file);
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file);
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file);
            }
            return url;
        },
        Write() {
            var p = document.getElementById("write");
            p.style.display = "none";
        },
        UpLoad() {
            const date = new Date();
            var json = {
                "picture": this.$data.PictureData,
                "title": this.$data.textarea2,
                "name": this.$root.userName,
                "date": date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate(),
            }

            var p = JSON.stringify(json);
            var xhr = new XMLHttpRequest();
            xhr.open("post", "http://127.0.0.1:8080/uploadQuestion");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send(p);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4) {
                    if (xhr.status >= 200 & xhr.status < 300) {
                        if (xhr.responseText == "1") {
                            alert("上传成功");
                            location.href = "main.html";
                        } else {
                            alert("上传失败");
                        }
                    }
                }
            }
        }
    }
})