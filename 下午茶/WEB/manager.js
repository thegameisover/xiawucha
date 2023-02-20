const manager = Vue.extend({
    template: `
    <div id=manager>
    <el-row :gutter="20">
    <el-col :span="16">
    <div class="grid-content bg-purple" id="Picture">
    <div>轮播图(最多上传4张图片)</div>
    <el-upload
  action="http://127.0.0.1:8080/sssh"
  list-type="picture-card"
  :on-preview="handlePictureCardPreview"
  :on-remove="handleRemove" :limit=4>
  <i class="el-icon-plus"></i>
</el-upload>
<el-dialog :visible.sync="dialogVisible">
  <img width="100%" :src="dialogImageUrl" alt="">
</el-dialog>
    </div>
    </el-col>
    <el-col :span="8"><div class="grid-content bg-purple">
    <div>所有用户</div>
    <ul id="user">
    <li v-for="p in user" :key="p.id" class="user">
    <el-collapse v-model="activeNames" @change="handleChange">
    <el-collapse-item :title="p.name" >
      <div class="User"> <el-button type="danger" icon="el-icon-delete" circle></el-button></div>
      <div class="User"><el-button type="primary" icon="el-icon-edit" circle></el-button></div>
      <div class="User"> <el-button type="warning" icon="el-icon-star-off" circle></el-button></div>
      <div style="clear:both"></div>
    </el-collapse-item>
  </el-collapse>
    </li>
    </ul>
    </div>
    </el-col>
  </el-row>


  <!--图书-->
  <el-row :gutter="20">
    <el-col :span="8"><div class="grid-content bg-purple">
    <div id="addBook">
    <div>添加图书</div>
    <div>
    <el-upload
  action="https://jsonplaceholder.typicode.com/posts/"
  list-type="picture-card"
  :on-preview="handlePictureCardPreview1"
  :on-remove="handleRemove1" :limit=1>
  <i class="el-icon-plus"></i>
</el-upload>
<el-dialog :visible.sync="dialogVisible1">
  <img width="100%" :src="dialogImageUrl1" alt="">
</el-dialog>
    </div>
    <el-input
  placeholder="请输入书名"
  v-model="input0"
  clearable>
</el-input>
<el-input
  placeholder="请输入作者"
  v-model="input1"
  clearable>
</el-input>
<el-input
  placeholder="请输入作者国家"
  v-model="input2"
  clearable>
</el-input>
<el-input
  type="textarea"
  autosize
  placeholder="请输入简介"
  v-model="input3">
</el-input>
<template>
  <el-radio v-model="radio" label="1">文学</el-radio>
  <el-radio v-model="radio" label="2">历史</el-radio>
  <el-radio v-model="radio" label="3">科幻</el-radio>
  <el-radio v-model="radio" label="4">玄幻</el-radio>
  <el-radio v-model="radio" label="5">童话故事</el-radio>
  <el-radio v-model="radio" label="6">漫画</el-radio>
  <el-radio v-model="radio" label="7">诺贝尔文学奖</el-radio>
</template>
<el-button type="primary" @click="submit">提交</el-button>
    </div>
    </div>
    </el-col>

    <!--电影-->
    <el-col :span="8"><div class="grid-content bg-purple">
    <div id="addMovie">
    <div>添加电影</div>
    <div>
    <el-upload
    action="https://jsonplaceholder.typicode.com/posts/"
    list-type="picture-card"
    :on-preview="handlePictureCardPreview2"
    :on-remove="handleRemove2" :limit=1>
    <i class="el-icon-plus"></i>
  </el-upload>
  <el-dialog :visible.sync="dialogVisible2">
    <img width="100%" :src="dialogImageUrl2" alt="">
  </el-dialog>
    </div>
    <el-input
    placeholder="请输入电影名"
    v-model="input4"
    clearable>
  </el-input>
  <el-input
    placeholder="请输入导演"
    v-model="input5"
    clearable>
  </el-input>
  <el-input
    placeholder="国家"
    v-model="input6"
    clearable>
  </el-input>
  <el-input
  placeholder="年份"
  v-model="input7"
  clearable>
</el-input>
  <el-input
    type="textarea"
    autosize
    placeholder="请输入简介"
    v-model="input8">
  </el-input>
  <template>
  <el-radio v-model="radio1" label="1">喜剧</el-radio>
  <el-radio v-model="radio1" label="2">爱情</el-radio>
  <el-radio v-model="radio1" label="3">动作</el-radio>
  <el-radio v-model="radio1" label="4">犯罪</el-radio>
  <el-radio v-model="radio1" label="5">恐怖</el-radio>
  <el-radio v-model="radio1" label="6">科幻</el-radio>
</template>
<template>
  <el-radio v-model="radio2" label="1">免费</el-radio>
  <el-radio v-model="radio2" label="2">vip</el-radio>
</template>
<el-button type="primary" @click="submit1">提交</el-button>
    </div>
    </div></el-col>


    <!--图书-->
    <el-col :span="8"><div class="grid-content bg-purple">
    <div>
    <div>删除或修改图书</div>
    <el-input
    placeholder="请输入书名"
    v-model="input9"
    clearable>
  </el-input>
  <el-button type="primary" @click="alert">查找</el-button>
  <div>
    <el-upload
  action="https://jsonplaceholder.typicode.com/posts/"
  list-type="picture-card"
  :on-preview="handlePictureCardPreview3"
  :on-remove="handleRemove3" :limit=1>
  <i class="el-icon-plus"></i>
</el-upload>
<el-dialog :visible.sync="dialogVisible3">
  <img width="100%" :src="dialogImageUrl3" alt="">
</el-dialog>
    </div>
    <el-input
  placeholder="请输入书名"
  v-model="input10"
  clearable>
</el-input>
<el-input
  placeholder="请输入作者"
  v-model="input11"
  clearable>
</el-input>
<el-input
  placeholder="请输入作者国家"
  v-model="input12"
  clearable>
</el-input>
<el-input
  type="textarea"
  autosize
  placeholder="请输入简介"
  v-model="input13">
</el-input>
<template>
  <el-radio v-model="radio3" label="1">文学</el-radio>
  <el-radio v-model="radio3" label="2">历史</el-radio>
  <el-radio v-model="radio3" label="3">科幻</el-radio>
  <el-radio v-model="radio3" label="4">玄幻</el-radio>
  <el-radio v-model="radio3" label="5">童话故事</el-radio>
  <el-radio v-model="radio3" label="6">漫画</el-radio>
  <el-radio v-model="radio3" label="7">诺贝尔文学奖</el-radio>
</template>
<el-button type="primary" @click="submit2">提交</el-button>
<el-button type="primary" @click="submit3">删除</el-button>
    </div>
    </div></el-col>
  </el-row>


  <el-row :gutter="20">
  <!--删除或修改电影-->
    <el-col :span="8"><div class="grid-content bg-purple">
    <div>
    <div>删除或修改电影</div>
    <el-input
    placeholder="请输入电影名"
    v-model="input14"
    clearable>
  </el-input>
  <el-button type="primary" @click="alert1">查找</el-button>
  <div>
    <el-upload
    action="https://jsonplaceholder.typicode.com/posts/"
    list-type="picture-card"
    :on-preview="handlePictureCardPreview4"
    :on-remove="handleRemove4" :limit=1>
    <i class="el-icon-plus"></i>
  </el-upload>
  <el-dialog :visible.sync="dialogVisible4">
    <img width="100%" :src="dialogImageUrl4" alt="">
  </el-dialog>
    </div>
    <el-input
    placeholder="请输入电影名"
    v-model="input15"
    clearable>
  </el-input>
  <el-input
    placeholder="请输入导演"
    v-model="input16"
    clearable>
  </el-input>
  <el-input
    placeholder="国家"
    v-model="input17"
    clearable>
  </el-input>
  <el-input
  placeholder="年份"
  v-model="input18"
  clearable>
</el-input>
  <el-input
    type="textarea"
    autosize
    placeholder="请输入简介"
    v-model="input19">
  </el-input>
  <template>
  <el-radio v-model="radio4" label="1">喜剧</el-radio>
  <el-radio v-model="radio4" label="2">爱情</el-radio>
  <el-radio v-model="radio4" label="3">动作</el-radio>
  <el-radio v-model="radio4" label="4">犯罪</el-radio>
  <el-radio v-model="radio4" label="5">恐怖</el-radio>
  <el-radio v-model="radio4" label="6">科幻</el-radio>
</template>
<template>
  <el-radio v-model="radio5" label="1">免费</el-radio>
  <el-radio v-model="radio5" label="2">vip</el-radio>
</template>
<el-button type="primary" @click="submit4">提交</el-button>
<el-button type="primary" @click="submit5">删除</el-button>
    </div>
    </div></el-col>
    <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
    <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
  </el-row>
    </div>`,
    data() {
        return {
            input0: '',
            input1: '',
            input2: '',
            input3: '',
            input4: '',
            input5: '',
            input6: '',
            input7: '',
            input8: '',
            input9: '',
            input10: '',
            input11: '',
            input12: '',
            input13: '',
            input14: '',
            input15: '',
            input16: '',
            input17: '',
            input18: '',
            input19: '',
            radio: '1',
            radio1: '1',
            radio2: '1',
            radio3: '1',
            radio4: '1',
            radio5: '1',
            dialogImageUrl: '',
            dialogVisible: false,
            dialogImageUrl1: '',
            dialogVisible1: false,
            dialogImageUrl2: '',
            dialogVisible2: false,
            dialogImageUrl3: '',
            dialogVisible3: false,
            dialogImageUrl4: '',
            dialogVisible4: false,
            activeNames: ['1'],
            user: [{ id: 1, name: '张三' }, { id: 2, name: '张三' }, { id: 3, name: '张三' }, { id: 4, name: '张三' }, { id: 5, name: '张三' }, { id: 6, name: '张三' }, { id: 7, name: '张三' }, { id: 8, name: '张三' }]
        }
    },
    methods: {
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        },
        handleChange(val) {
            console.log(val);
        },
        handleRemove1(file, fileList) {
            console.log(file, fileList);
        },
        handlePictureCardPreview1(file) {
            this.dialogImageUrl1 = file.url;
            this.dialogVisible1 = true;
        },
        handleRemove2(file, fileList) {
            console.log(file, fileList);
        },
        handlePictureCardPreview2(file) {
            this.dialogImageUrl2 = file.url;
            this.dialogVisible2 = true;
        },
        handleRemove3(file, fileList) {
            console.log(file, fileList);
        },
        handlePictureCardPreview3(file) {
            this.dialogImageUrl3 = file.url;
            this.dialogVisible3 = true;
        },
        handleRemove4(file, fileList) {
            console.log(file, fileList);
        },
        handlePictureCardPreview4(file) {
            this.dialogImageUrl4 = file.url;
            this.dialogVisible4 = true;
        },
        submit() {

        },
        submit1() {

        },
        submit2() {

        },
        submit3() {

        },
        submit4() {

        },
        submit5() {

        },
        alert() {

        },
        alert1() {

        },

    },
})