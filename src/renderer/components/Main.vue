<template>
    <el-container>
        <el-aside width="10%"></el-aside>
        <el-container>
            <el-header>批量重命名图片工具</el-header>
            <el-main>
                <el-form :inline="true" :model="photos" class="demo-form-inline">
                    <el-form-item>
                        <el-input v-model="photos.pathStr" placeholder="请输入目标文件目录"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">确定</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
            <el-footer>本工具由guyuexuan039开发</el-footer>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "Main",
        data() {
            return {
                photos: {
                    pathStr: '', //E:\photos\网图
                }
            }
        },
        methods: {
            onSubmit() {
                console.log(this.photos.pathStr)
                this.$axios.post('http://localhost:8088/hello/world', {
                    pathStr: this.photos.pathStr    //将路径封装在 pathStr key 中
                }).then(response => {
                    if (response.data.code == '200') {
                        this.$message({
                            message: '恭喜你，批量重命名图片成功',
                            type: 'success'
                        });
                    }
                    console.log(response, "success")
                    this.photos.pathStr = ''
                }).catch(error => {
                        this.$message.error('出错了哦');
                        this.photos.pathStr = ''
                    }
                )

            }
        }
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
</style>
