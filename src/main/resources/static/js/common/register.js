let v = new Vue({
   el:'#register',
   data:function () {
       return{
           user:{
               username:'',
               password:'',
               email:''
           },
           twoPwd:''
       }
   } ,
    methods:{
        doSave:function () {
            if (this.twoPwd !== this.user.password){
                alert("两次密码不一致")
            }else {
                axios({
                    url:'/common/doSave',
                    method:'post',
                    data:this.user
                }).then(response=>{
                    if (response.data.success){
                        alert(response.data.msg);
                        location.href = '/common/login';
                    } else {
                        alert(response.data.msg)
                    }
                })
            }
        }
    }
});