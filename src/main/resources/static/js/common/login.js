let v = new Vue({
    el:'#login',
    data:{
        user:{
            username:'',
            password:'',
            code:''
        },
        path:''
    },
    methods:{
        changeCode:function () {
            this.path = '/code.jpg?' + new Date();
        },
        login:function () {
            if ($("input[id='brand1']:checked").val() === 'on'){
                this.user.remember = 1;
            } else {
                this.user.remember = 0;
            }
            axios({
                url:'/common/toLogin',
                method:'post',
                data:this.user
            }).then(response=>{
                if (response.data.success){
                    location.href = "/home/home";
                } else {
                    alert(response.data.obj);
                }
            })
        }
    },
    created:function () {
        this.path = '/code.jpg?' + new Date();
    }
});