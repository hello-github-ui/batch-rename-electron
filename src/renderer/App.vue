<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: 'batch-rename-picture'
    }
</script>

<style>
    /* CSS */
    body{
        height: 100%;
        width: 100%;
    }

    #app{
        height: 500px;
        width: 900px;
        margin-top: 100px;
        margin-left: 35px;
    }

    body{
        background-color: aqua;
        background-image: url("https://img.imgdb.cn/item/604ba03b5aedab222cf8ce17.jpg");
    }
</style>
