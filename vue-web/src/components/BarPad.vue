
<template>
    <div class="barPad">
        <div>
            <RouterLink to="/home">
                <i class="fas fa-home"></i>
                <br />首页
            </RouterLink>
        </div>
        <div>
            <!-- todo -->
            <RouterLink to="/home">
                <i class="fas fa-search"></i>
                <br />发现
            </RouterLink>
        </div>
        <div>
            <RouterLink to="/order">
                <i class="fas fa-shopping-cart"></i>
                <br />订单
            </RouterLink>
        </div>
        <div>
            <RouterLink to="/my">
                <i class="fas fa-user"></i>
                <br />我的
            </RouterLink>
        </div>
    </div>
</template>

<script setup lang="ts">
import { RouterLink } from "vue-router";
import "../assets/css/output.css";
</script>