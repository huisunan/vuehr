<template>
    <el-dialog
            :visible.sync="visible"
            title="人员调动"
            @open="destroy = true"
            @closed="destroy = false"
    >
        <el-form
                :model="formData"
                label-width="120px"
        >
            <el-form-item
                    label="员工ID">
                <el-input v-model:number="formData.eid"></el-input>
            </el-form-item>
            <el-form-item
                    label="部门ID">
                <el-popover
                        placement="right"
                        title="请选择部门"
                        width="200"
                        trigger="manual"
                        v-model="popVisible">
                    <el-tree default-expand-all :data="allDeps" :props="defaultProps"
                             @node-click="handleNodeClick"></el-tree>
                    <div slot="reference"
                         style="width: 150px;display: inline-flex;font-size: 13px;border: 1px solid #dedede;height: 26px;border-radius: 5px;cursor: pointer;align-items: center;padding-left: 8px;box-sizing: border-box"
                         @click="showDepView">{{inputDepName}}
                    </div>
                </el-popover>
            </el-form-item>
            <el-form-item
                    label="职位ID">
                <el-select v-model="formData.afterjobid" placeholder="职位" size="mini" style="width: 130px;">
                    <el-option
                            v-for="item in positions"
                            :key="item.id"
                            :label="item.name"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item
                    label="原因">
                <el-input  type="textarea"
                           :rows="2"
                           placeholder="请输入内容"
                           clearable v-model="formData.reason"></el-input>
            </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
    <el-button @click="visible = false">取 消</el-button>
    <el-button type="primary" @click="add">确 定</el-button>
  </span>
    </el-dialog>
</template>

<script>
    import {postRequest} from "../../../utils/api";

    export default {
        name: "PerMvDialog",
        data() {
            return {
                visible: false,
                formData: {
                    eid: null,
                    afterdepid: null,
                    afterjobid: null,
                    reason: null
                },
                destroy: true,
                allDeps: [],
                positions: [],
                defaultProps: {
                    children: 'children',
                    label: 'name'
                },
                popVisible: false,
                inputDepName:null,
            }
        },mounted() {
            this.initPositions();
            this.initDeps()
        },
        methods:{
            add(){
                postRequest('/personnel/move/add',this.formData).then(res=>{
                    this.$emit('update')
                    this.visible = false
                })
            },
            handleNodeClick(data) {
                this.inputDepName = data.name;
                this.formData.afterdepid = data.id;
                this.popVisible = !this.popVisible
            },
            showDepView() {
                this.popVisible = !this.popVisible
            }, initPositions() {
                this.getRequest('/employee/basic/positions').then(resp => {
                    if (resp) {
                        this.positions = resp;
                    }
                })
            },initDeps() {
                this.getRequest('/employee/basic/deps').then(resp => {
                    if (resp) {
                        this.allDeps = resp;
                        window.sessionStorage.setItem("deps", JSON.stringify(resp));
                    }
                })
            },
        }
    }
</script>

<style scoped>

</style>
